package by.laligulbani.vk.model.listener;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.InputStream;

import by.laligulbani.vk.model.parser.GsonParser;
import by.laligulbani.vk.model.parser.IParser;

public class GsonResponseListener<T> implements ResponseListener {

    private final Class<T> type;
    private Exception exception;
    private T result;
    private IParser<T> mParser;

    public GsonResponseListener(final Class<T> type) {
        this.type = type;
        this.mParser = new GsonParser();
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
        try {
            result = mParser.parse(stream, type);
        } catch (final Exception e) {
            exception = e;
        }
    }
}