package by.laligulbani.vk.model.service.image.cache;

import android.graphics.Bitmap;

import java.io.File;

public interface IDiskCache {

    File get(String url);

    void save(String url, Bitmap bitmap);

    boolean contain(String url);
}
