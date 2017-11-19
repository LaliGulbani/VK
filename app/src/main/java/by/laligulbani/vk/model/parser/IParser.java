package by.laligulbani.vk.model.parser;

import java.io.InputStream;

public interface IParser<T> {
    T parse(final InputStream mIntputStream, final Class<T> mClass);
}
