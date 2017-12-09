package by.laligulbani.vk.model.parser;

public class IParserFactory {

    private static IParser INSTANCE = new GsonParser();

    public static IParser getInstance() {
        return INSTANCE;
    }
}
