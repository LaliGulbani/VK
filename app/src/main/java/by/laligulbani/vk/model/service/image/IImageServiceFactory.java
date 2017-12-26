package by.laligulbani.vk.model.service.image;

import java.io.File;

import by.laligulbani.vk.model.service.executor.IExecutorServiceFactory;
import by.laligulbani.vk.model.service.image.cache.IDiskCacheFactory;

public class IImageServiceFactory {

    private static File cacheDir = new File("some-path");

    private static IImageService INSTANCE = new ImageService(
            IExecutorServiceFactory.getInstance(),
            IDiskCacheFactory.getInstance(cacheDir));

    public static IImageService getInstance() {
        return INSTANCE;
    }
}
