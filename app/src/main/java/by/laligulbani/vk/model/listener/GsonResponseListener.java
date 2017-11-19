package by.laligulbani.vk.model.listener;


import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;

public class GsonResponseListener<T> implements ResponseListener {

    private final Class<T> type;
    private Exception exception;
    private T result;

    public GsonResponseListener(final Class<T> type) {
        this.type = type;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public void onException(final Exception exception) {
        this.exception = exception;

    }

    @Override
    public T getResult() {
        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onResponse(final InputStream stream) throws Exception {
        try (final InputStreamReader inputStreamReader = new InputStreamReader(stream)) {
            result = new GsonBuilder()
                    .setLenient()
                    .create()
                    .fromJson(inputStreamReader, type);
        } catch (final Exception e) {
            exception = e;
        }
    }
}