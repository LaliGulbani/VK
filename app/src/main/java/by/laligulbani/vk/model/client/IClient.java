package by.laligulbani.vk.model.client;

public interface IClient {

    void request(String url, HttpClient.ResponseListener listener);
}
