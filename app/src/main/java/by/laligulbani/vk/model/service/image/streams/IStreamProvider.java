package by.laligulbani.vk.model.service.image.streams;

import java.io.IOException;

public interface IStreamProvider<T> {
    String get(T path) throws IOException;
}
