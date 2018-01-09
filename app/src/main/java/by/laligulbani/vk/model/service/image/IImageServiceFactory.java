package by.laligulbani.vk.model.service.image;

import by.laligulbani.vk.model.service.executor.IExecutorServiceFactory;
import by.laligulbani.vk.model.service.image.cache.IDiskCacheFactory;
import by.laligulbani.vk.model.util.ContextHolder;

public class IImageServiceFactory {

    private static IImageService INSTANCE = new ImageService(
            IExecutorServiceFactory.getInstance(),
            IDiskCacheFactory.getInstance(ContextHolder.getContext().getCacheDir()));

    public static IImageService getInstance() {
        return INSTANCE;
    }
}
