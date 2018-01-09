package by.laligulbani.vk.model.service.image.entity;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

public class ImageResult {

    private final WeakReference<ImageView> target;
    private final Exception exception;
    private final Bitmap bitmap;
    private final String url;

    private ImageResult(final Bitmap bitmap, final Exception exception, final String url, final WeakReference<ImageView> target) {
        this.exception = exception;
        this.bitmap = bitmap;
        this.target = target;
        this.url = url;
    }

    public ImageResult(final Exception e) {
        this(null, e, null, null);
    }

    public ImageResult(final Bitmap bitmap, final String url, final WeakReference<ImageView> target) {
        this(bitmap, null, url, target);
    }

    public String getUrl() {
        return url;
    }

    public WeakReference<ImageView> getTarget() {
        return target;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Exception getException() {
        return exception;
    }
}
