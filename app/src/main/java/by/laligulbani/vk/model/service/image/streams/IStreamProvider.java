package by.laligulbani.vk.model.service.image.streams;

import java.io.IOException;
import java.io.InputStream;

public interface IStreamProvider<T> {
    InputStream get(T path) throws IOException;
}
