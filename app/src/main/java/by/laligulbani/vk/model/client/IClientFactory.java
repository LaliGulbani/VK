package by.laligulbani.vk.model.client;

public class IClientFactory {

    public static IClient getInstance() {
        return new HttpClient();
    }
}
