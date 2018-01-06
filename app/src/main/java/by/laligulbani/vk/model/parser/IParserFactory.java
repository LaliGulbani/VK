package by.laligulbani.vk.model.parser;

public class IParserFactory {

    public static IParser getInstance() {
        return new GsonParser();
    }
}
