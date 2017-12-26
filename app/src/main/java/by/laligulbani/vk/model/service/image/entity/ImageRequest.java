package by.laligulbani.vk.model.service.image.entity;

import android.widget.ImageView;

import java.lang.ref.WeakReference;

public class ImageRequest {

    private final String url;
    private int width;
    private int height;
    private final WeakReference<ImageView> target;

    private ImageRequest(final Builder builder) {
        this.url = builder.url;
        this.target = builder.target;
        this.width = builder.width;
        this.height = builder.height;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public WeakReference<ImageView> getTarget() {
        return target;
    }

    public static final class Builder {

        private String url;
        private WeakReference<ImageView> target;
        private int height;
        private int width;

        public Builder load(final String url) {
            this.url = url;
            return this;
        }

        public Builder into(final ImageView val) {
            this.target = new WeakReference<>(val);
            return this;
        }

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder height(final int height) {
            this.height = height;
            return this;
        }

        public ImageRequest build() {
            return new ImageRequest(this);
        }
    }
}
