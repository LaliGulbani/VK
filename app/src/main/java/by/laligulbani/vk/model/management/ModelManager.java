package by.laligulbani.vk.model.management;

import java.util.List;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.entity.messages.Message;
import by.laligulbani.vk.entity.messages.MessageResponse;
import by.laligulbani.vk.model.client.HttpClient;
import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.listener.GsonResponseListener;
import by.laligulbani.vk.model.listener.ResponseListener;

public class ModelManager implements IModelManagement {
   // private static final String token = mPreferences.getString(PREFERENCES_TOKEN, "");

    private IClient mClient;

    public ModelManager() {
        this.mClient = new HttpClient();
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
