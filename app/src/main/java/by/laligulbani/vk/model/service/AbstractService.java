package by.laligulbani.vk.model.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.InputStream;

import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.parser.IParser;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class AbstractService {

    private final IParser parser;
    private final IClient client;
    protected final Context context;

    public AbstractService(final Context context,
                           final IParser parser,
                           final IClient client) {
        this.context = context;
        this.parser = parser;
        this.client = client;
    }

    protected <T> T execute(final String url, final Class<T> aClass) {
        final InputStream request = client.request(url);
        return parser.parse(request, aClass);
    }

    protected boolean checkInternetConnection() {

        final ConnectivityManager cm = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        if (cm == null) {
            return false;
        }
        final NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
