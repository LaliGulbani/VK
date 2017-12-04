package by.laligulbani.vk.model.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import by.laligulbani.vk.model.listener.ResponseListener;

public class HttpClient implements IClient {

    private HttpURLConnection con;

    @Override
    public void request(final String url, final ResponseListener listener) {
        try {
            final InputStream is = openStream(url);
            listener.onResponse(is);
            con.disconnect();
        } catch (final Exception t) {
            listener.onException(t);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }

    InputStream openStream(final String url) throws IOException {
        con = (HttpURLConnection) (new URL(url)).openConnection();
        return con.getInputStream();
    }
}
