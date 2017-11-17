package by.laligulbani.vk.model.management;

import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

import javax.xml.transform.Result;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.model.client.HttpClient;
import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.entity.Message;

public class ModelManager implements IModelManagement {

    private IClient mClient;

    public ModelManager() {
        this.mClient = new HttpClient();
    }

    @Override
    public Collection<Message> getMessages(final String token) {

        final String url = Api.MESSENGES_GET +
                "?" + "access_token=" + token
                + "&" + "count=100";

        final MyResponseListener listener = new MyResponseListener();
        mClient.request(url, listener);
        final Result result = listener.getResult();
        //TODO fix this, try to find how to convert result in collection messages
        return null;
    }

    @Override
    public void sendMessages(String token, String message) {
    }

    private static class MyResponseListener implements HttpClient.ResponseListener {
        private static final String TAG = "MyResponseListener";

        private Result result;
        private Throwable mThrowable;

        @Override
        public void onResponse(final InputStream pInputStream) throws Exception {
            InputStreamReader inputStreamReader = null;
            try {
                inputStreamReader = new InputStreamReader(pInputStream);
                result = new GsonBuilder()
                        .setLenient()
                        .create().fromJson(inputStreamReader, Result.class);
            } catch (Exception e) {
                mThrowable = e;
            } finally {
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (final Exception ignored) {
                    }
                }
            }
        }

        public Throwable getThrowable() {
            return mThrowable;
        }

        @Override
        public void onError(final Throwable pThrowable) {
            mThrowable = pThrowable;
        }

        public Result getResult() {
            return result;
        }
    }
}
