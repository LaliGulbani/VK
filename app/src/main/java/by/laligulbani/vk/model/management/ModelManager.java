package by.laligulbani.vk.model.management;

import java.util.List;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.model.client.HttpClient;
import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.entity.message.Item;
import by.laligulbani.vk.model.entity.message.Response;
import by.laligulbani.vk.model.listener.GsonResponseListener;
import by.laligulbani.vk.model.listener.ResponseListener;

public class ModelManager implements IModelManagement {

    private IClient mClient;

    public ModelManager() {
        this.mClient = new HttpClient();
    }

    @Override
    public List<Item> getMessages(final String token) {

        final String url = Api.MESSAGES +
                "?" + "access_token=" + token
                + "&" + "count=100";

        Response execute = execute(url, Response.class);
        return execute.items;
    }

    @Override
    public void sendMessages(String token, String message) {
    }

    private <T> T execute(final String url, final Class<T> aClass) {
        final ResponseListener<T> listener = new GsonResponseListener<>(aClass);
        mClient.request(url, listener);

        if (listener.getException() == null) {
            return listener.getResult();
        } else {
            throw new RuntimeException("We have some problems on connection side.", listener.getException());
        }
    }
}
