package by.laligulbani.vk.model.service.image.cache;

import java.io.File;

import by.laligulbani.vk.model.service.image.cache.assistent.DiskCacheAssistant;
import by.laligulbani.vk.model.service.image.cache.assistent.IDiskCacheAssistant;

public class IDiskCacheFactory {

    private static final DiskCacheAssistant DISK_CACHE_ASSISTANT = new DiskCacheAssistant();
    private static BaseIDiskCache baseIDiskCache;

    public static IDiskCache getInstance(final File cacheDir) {
        if (baseIDiskCache == null) {
            baseIDiskCache = new BaseIDiskCache(getAssistantInstance(), cacheDir);
        }
        return baseIDiskCache;
    }

    public static IDiskCacheAssistant getAssistantInstance() {
        return DISK_CACHE_ASSISTANT;
    }
}
