package by.laligulbani.vk.model.converter;

public interface IConverterFactory {

    private static IConverter INSTANCE = new Converter();

    public static IConverter getInstance() {
        return INSTANCE;
    }
}
