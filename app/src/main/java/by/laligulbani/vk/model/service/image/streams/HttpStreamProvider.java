package by.laligulbani.vk.model.service.image.streams;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import by.laligulbani.vk.model.client.IClient;

public class HttpStreamProvider implements IStreamProvider<URL> {

    private final IClient client;

    HttpStreamProvider(final IClient client) {
        this.client = client;
    }

    @Override
    public InputStream get(final URL path) throws IOException {
        return new ByteArrayInputStream(client.request(path));
    }
}
