package by.laligulbani.vk.model.parser;

public interface IParser {
    <T> T parse(final String json, final Class<T> mClass);
}
