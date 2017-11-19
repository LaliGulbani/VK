package by.laligulbani.vk.model.listener;


import java.io.InputStream;

public interface ResponseListener<T> {

    void onResponse(final InputStream stream) throws Exception;

    Exception getException();

    void onException(final Exception exception);

    T getResult();
}
