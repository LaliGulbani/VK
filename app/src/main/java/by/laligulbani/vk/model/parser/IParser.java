package by.laligulbani.vk.model.parser;

public interface IParser {
    <T> T parse(final String is, final Class<T> mClass);
}
