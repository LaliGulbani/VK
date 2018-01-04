package by.laligulbani.vk.model.client;

import java.net.URL;

public interface IClient {

    String request(String url);

    byte[] request(URL uri);
}
