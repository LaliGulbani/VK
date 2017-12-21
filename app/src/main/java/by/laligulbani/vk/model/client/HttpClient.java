package by.laligulbani.vk.model.client;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient implements IClient {

    @Override
    public InputStream request(final String url) {
        HttpURLConnection con = null;
        try {
            final URL netUrl = new URL(url);
            con = (HttpURLConnection) netUrl.openConnection();


            try (final Reader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                // TODO: 21-Dec-17 remove apache utils
                final String response = IOUtils.toString(reader);
                return new ByteArrayInputStream(response.getBytes());
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