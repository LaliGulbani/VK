package by.laligulbani.vk.model.client;

import by.laligulbani.vk.model.listener.ResponseListener;

public interface IClient {

    void request(String url, ResponseListener listener);
}
