package by.laligulbani.vk.model.service.image.entity;

import android.graphics.Bitmap;

public class ImageResult {

    private final ImageRequest request;
    private final Bitmap bitmap;
    private final Exception exception;


    public ImageResult(final Exception exception) {
        this(null, null, exception);
    }

    public ImageResult(final ImageRequest request, final Bitmap bitmap) {
        this(request, bitmap, null);
    }

    public ImageResult(final ImageRequest request, final Bitmap bitmap, final Exception exception) {
        this.request = request;
        this.bitmap = bitmap;
        this.exception = exception;
    }

    public ImageRequest getRequest() {
        return request;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Exception getException() {
        return exception;
    }
}
