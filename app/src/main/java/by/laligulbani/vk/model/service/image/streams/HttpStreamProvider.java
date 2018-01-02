package by.laligulbani.vk.model.service.image.streams;

import java.io.IOException;

import by.laligulbani.vk.model.client.IClient;

public class HttpStreamProvider implements IStreamProvider<String> {

    private final IClient client;

    HttpStreamProvider(final IClient client) {
        this.client = client;
    }

    @Override
    public String get(final String path) throws IOException {
        return client.request(path);
    }
}
