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

/*
public class FlickrFetchr {
    public byte[] getUrlBytes(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() +
                        ": with " +
                        urlSpec);
            }
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }

    public String getUrlString(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }
}
 */