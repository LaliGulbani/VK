package by.laligulbani.vk.model.service.image.streams;

import java.io.File;
import java.net.URL;

import by.laligulbani.vk.model.client.IClientFactory;

public class IStreamProviderFactory {

    public static <T> IStreamProvider<T> getInstance(final Class<T> clazz) {

        if (clazz.equals(File.class)) {
            return (IStreamProvider<T>) new FileStreamProvider();
        } else if (clazz.equals(URL.class)) {
            return (IStreamProvider<T>) new HttpStreamProvider(IClientFactory.getInstance());
        }

        throw new IllegalArgumentException("IStreamProvider not implemented for this class ");
    }
}
