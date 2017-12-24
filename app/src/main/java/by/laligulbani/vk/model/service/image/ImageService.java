package by.laligulbani.vk.model.service.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import by.laligulbani.vk.R;

public class ImageService implements IImageService {

    private final Context context;
    private Bitmap bitmap;

    ImageService(final Context context) {
        this.context = context;
    }

    @Override
    public Bitmap getImage(String imageId) {
        if (bitmap == null) {
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_cake_black_24dp);
        }
        return bitmap;
    }
}
