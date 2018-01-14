package by.laligulbani.vk.model.service.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.util.LruCache;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import by.laligulbani.vk.model.service.executor.IExecutorService;
import by.laligulbani.vk.model.service.image.cache.IDiskCache;
import by.laligulbani.vk.model.service.image.entity.ImageRequest;
import by.laligulbani.vk.model.service.image.entity.ImageResult;
import by.laligulbani.vk.model.service.image.streams.IStreamProviderFactory;
import by.laligulbani.vk.model.task.Task;

public class ImageService implements IImageService {

    private static final Drawable EMPTY_DRAWABLE = new ColorDrawable(255);

    private final IExecutorService executorService;
    private final IDiskCache diskCache;

    private final BlockingDeque<ImageRequest> queue;
    private final LruCache<String, Bitmap> cache;

    ImageService(final IExecutorService executorService,
                 final IDiskCache diskCache) {

        this.executorService = executorService;
        this.diskCache = diskCache;

        this.queue = new LinkedBlockingDeque<>();
        this.cache = new StringBitmapLruCache();
    }

    @Override
    public void enqueue(final ImageRequest request) {

        final ImageView imageView = request.getTarget().get();

        if (request.getUrl() == null || imageView == null) {
            return;
        }

        imageView.setImageBitmap(null);

        if (imageHasSize(request)) {
            imageView.setTag(request.getUrl());
            queue.addFirst(request);
            dispatchLoading();
        } else {
            deferImageRequest(request);
        }
    }

    private void dispatchLoading() {
        executorService.executeOnExecutor(new Task<>(this::getImageResult, this::processImageResult));
    }

    private ImageResult getImageResult() {

        try {
            final ImageRequest request = queue.takeFirst();

            final String url = request.getUrl();
            synchronized (this) {
                final Bitmap bitmap = cache.get(url);
                if (bitmap != null) {
                    return new ImageResult(bitmap, request.getUrl(), request.getTarget());
                }
            }

            if (diskCache.contain(url)) {
                final InputStream fileStream = IStreamProviderFactory.getInstance(File.class).get(diskCache.get(url));
                final Bitmap bitmap = getScaledBitmap(fileStream, request.getWidth(), request.getHeight());
                if (bitmap != null) {
                    return new ImageResult(bitmap, request.getUrl(), request.getTarget());
                }
            }

            final InputStream inputStream = IStreamProviderFactory.getInstance(URL.class).get(new URL(url));
            final Bitmap bitmap = getScaledBitmap(inputStream, request.getHeight(), request.getWidth());
            if (bitmap != null) {
                cacheBitmap(request, bitmap);
                return new ImageResult(bitmap, request.getUrl(), request.getTarget());
            }

            return new ImageResult(new IllegalStateException("Bitmap is null"));

        } catch (final Exception e) {
            return new ImageResult(e);
        }
    }

    private void processImageResult(final ImageResult imageResult) {
        if (imageResult == null) {
            return;
        }

        final ImageView imageView = imageResult.getTarget().get();

        if (imageView == null) {
            return;
        }

        final Object tag = imageView.getTag();
        if (tag != null && tag.equals(imageResult.getUrl())) {

            final Drawable[] layers = {EMPTY_DRAWABLE, new BitmapDrawable(imageResult.getBitmap())};
            final TransitionDrawable drawable = new TransitionDrawable(layers);

            imageView.setImageDrawable(drawable);
            imageView.setImageBitmap(imageResult.getBitmap());

            drawable.startTransition(1000);
        }

    }

    private void deferImageRequest(final ImageRequest request) {

        final ImageView imageView = request.getTarget().get();
        if (imageView == null) {
            return;
        }

        imageView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {

            @Override
            public boolean onPreDraw() {

                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                final ImageView view = request.getTarget().get();

                if (view == null) {
                    return true;
                }

                if (view.getWidth() > 0 && view.getHeight() > 0) {
                    request.setWidth(view.getWidth());
                    request.setHeight(view.getHeight());
                    enqueue(request);
                }
                return true;
            }
        });
    }

    private boolean imageHasSize(final ImageRequest request) {

        if (request.getWidth() > 0 && request.getHeight() > 0) {
            return true;
        }

        final ImageView imageView = request.getTarget().get();
        if (imageView != null && imageView.getWidth() > 0 && imageView.getHeight() > 0) {
            request.setWidth(imageView.getWidth());
            request.setHeight(imageView.getHeight());
            return true;
        }

        return false;
    }

    private Bitmap getScaledBitmap(final InputStream inputStream, final int w, final int h) throws IOException {

        try (final InputStream is = inputStream;
             final ByteArrayOutputStream os = new ByteArrayOutputStream(is.available())) {

            final byte[] buffer = new byte[1 << 16];
            int i;
            while ((i = is.read(buffer)) > 0) {
                os.write(buffer, 0, i);
            }

            final byte[] bytes = os.toByteArray();

            final Options options = new Options();
            options.inSampleSize = calculateSampleSize(options, w, h);
            options.inJustDecodeBounds = false;

            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
        }
    }

    private int calculateSampleSize(final Options options, final int reqWidth, final int reqHeight) {

        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            int halfHeight = height / 2;
            int halfWidth = width / 2;

            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
                halfHeight /= 2;
                halfWidth /= 2;
            }
        }
        return inSampleSize;
    }

    private void cacheBitmap(final ImageRequest request, final Bitmap bitmap) throws IOException {

        synchronized (this) {
            cache.put(request.getUrl(), bitmap);
        }

        diskCache.save(request.getUrl(), bitmap);
    }

    private class StringBitmapLruCache extends LruCache<String, Bitmap> {

        private static final long MAX_MEMORY_FOR_IMAGES = 64 * 1024 * 1024;

        StringBitmapLruCache() {
            super((int) Math.min(Runtime.getRuntime().maxMemory() / 4, MAX_MEMORY_FOR_IMAGES));
        }

        @Override
        protected int sizeOf(final String key, final Bitmap value) {
            return key.length() + value.getByteCount();
        }
    }
}
