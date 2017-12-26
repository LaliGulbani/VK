package by.laligulbani.vk.model.service.image.cache.assistent;

import by.laligulbani.vk.model.util.MD5;

public class DiskCacheAssistant implements IDiskCacheAssistant {

    @Override
    public String getName(final String url) {
        return MD5.hash(url);
    }
}
