package by.laligulbani.vk.model.client;

public class IClientFactory {

    private static IClient INSTANCE = new HttpClient();

    public static IClient getInstance() {
        return INSTANCE;
    }
}
