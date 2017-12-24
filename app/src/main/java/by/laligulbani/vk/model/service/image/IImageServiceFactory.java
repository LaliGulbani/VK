package by.laligulbani.vk.model.service.image;

import by.laligulbani.vk.model.context.ContextHolder;

public class IImageServiceFactory {

    private static IImageService INSTANCE = new ImageService(ContextHolder.getContext());

    public static IImageService getInstance() {
        return INSTANCE;
    }
}
