package by.laligulbani.vk.model.management;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.InputStream;
import java.util.List;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.entity.friends.Friends;
import by.laligulbani.vk.entity.friends.FriendsResponse;
import by.laligulbani.vk.entity.messages.Message;
import by.laligulbani.vk.entity.messages.MessageResponse;
import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.db.IDataBase;
import by.laligulbani.vk.model.parser.IParser;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class ModelManager implements IModelManagement {

    private final IParser parser;
    private final IClient client;
    private final Context context;
    private final IDataBase dataBase;

    ModelManager(final Context context, final IClient client, final IParser parser, IDataBase dataBase) {
        this.client = client;
        this.parser = parser;
        this.context = context;
        this.dataBase = dataBase;
    }

    @Override
    public List<Message> getMessages(final String token) {

        final String url = Api.MESSAGES +
                "?" + "access_token=" + token
                + "&" + "count=100";

        if (checkInternetConnection(context)) {
            final MessageResponse response = execute(url, MessageResponse.class);
            //конвертер.трансорм(респонс), аналогия с парсером.
            final List<Message> messages = response.getMessages();
            dataBase.addMessages(messages);
            //проверка на уникальность сообщения в бд
        }

        return dataBase.getMessages();
    }

    @Override
    public void sendMessages(final String token, final String message) {
    }

    @Override
    public List<Friends> getFriends(String token) {
        final String url = Api.FRIENDS_GET;
        return execute(url, FriendsResponse.class).getFriends();
    }

    @Override
    public List<Friends> getFriendsOnline(String token) {
        final String url = Api.FRIENDS_ONLINE;
        return execute(url, FriendsResponse.class).getFriends();
    }


    private <T> T execute(final String url, final Class<T> aClass) {
        final InputStream request = client.request(url);
        return parser.parse(request, aClass);
    }

    private boolean checkInternetConnection(final Context context) {

        final ConnectivityManager cm = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        if (cm == null) {
            return false;
        }
        final NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}

