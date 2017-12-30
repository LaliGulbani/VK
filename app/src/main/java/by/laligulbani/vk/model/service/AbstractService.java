package by.laligulbani.vk.model.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.InputStream;

import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.parser.IParser;

import static android.content.Context.CONNECTIVITY_SERVICE;
import static by.laligulbani.vk.Api.EMPTY;
import static by.laligulbani.vk.ui.activity.LoginActivity.APP_PREFERENCES_NAME;
import static by.laligulbani.vk.ui.activity.LoginActivity.PREFERENCES_ID_USER;

public class AbstractService {

    private final IParser parser;
    private final IClient client;
    private final Context context;

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

    protected String getUserId() {
        return context
                .getSharedPreferences(APP_PREFERENCES_NAME, 0)
                .getString(PREFERENCES_ID_USER, EMPTY);
    }
}
