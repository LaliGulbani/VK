package by.laligulbani.vk.model.management;

import java.io.InputStream;
import java.util.List;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.entity.messages.Message;
import by.laligulbani.vk.entity.messages.MessageResponse;
import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.parser.IParser;

public class ModelManager implements IModelManagement {

    private final IParser parser;
    private final IClient client;

    ModelManager(final IClient client, final IParser parser) {
        this.client = client;
        this.parser = parser;
    }

    @Override
    public List<Message> getMessages(final String token) {

        final String url = Api.MESSAGES +
                "?" + "access_token=" + token
                + "&" + "count=100";

        MessageResponse execute = execute(url, MessageResponse.class);
        return execute.mMessages;
    }

    @Override
    public void sendMessages(final String token, final String message) {
    }

    private <T> T execute(final String url, final Class<T> aClass) {
        final InputStream request = client.request(url);
        return parser.parse(request, aClass);
    }
}
