package by.laligulbani.vk.model.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.net.HttpURLConnection.HTTP_OK;

public class HttpClient implements IClient {

    private static final int BUFFER_SIZE = 1024;

    @Override
    public InputStream request(final String url) {
        HttpURLConnection con = null;
        try {
            final URL netUrl = new URL(url);
            con = (HttpURLConnection) netUrl.openConnection();

            try (final InputStream in = con.getInputStream();
                 final ByteArrayOutputStream out = new ByteArrayOutputStream()) {

                if (con.getResponseCode() != HTTP_OK) {
                    throw new IOException(con.getResponseMessage() + ": with " + url);
                }

                final byte[] buffer = new byte[BUFFER_SIZE];
                int length = 0;

                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }

                return new ByteArrayInputStream(out.toByteArray());
            }

        } catch (final IOException e) {
            throw new IllegalStateException(e);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }
}