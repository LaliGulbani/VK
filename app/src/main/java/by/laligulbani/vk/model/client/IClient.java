package by.laligulbani.vk.model.client;

import java.io.InputStream;
import java.net.URL;

public interface IClient {

    InputStream request(String url);

    InputStream request(URL uri);
}
