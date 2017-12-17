package by.laligulbani.vk.model.management;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.InputStream;
import java.util.List;


import by.laligulbani.vk.Api;
import by.laligulbani.vk.entity.messages.Message;
import by.laligulbani.vk.entity.messages.MessageResponse;
import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.db.IDataBase;
import by.laligulbani.vk.model.parser.IParser;

public class ModelManager implements IModelManagement {

    private final IParser parser;
    private final IClient client;
    private final IDataBase dataBase;

    ModelManager(final IClient client, final IParser parser, IDataBase dataBase) {
        this.client = client;
        this.parser = parser;
        this.dataBase = dataBase;
    }

    @Override
    public List<Message> getMessages(final String token) {
        //TODO  добавить проверку на наличие интернета, алгоритм
        final String url = Api.MESSAGES +
                "?" + "access_token=" + token
                + "&" + "count=100";

       try {
           MessageResponse execute = execute(url, MessageResponse.class);
           return execute.getMessages();
       }catch(Exception ex){
           return dataBase.getMessages();
        }
    }



    @Override
    public void sendMessages(final String token, final String message) {
    }

    private <T> T execute(final String url, final Class<T> aClass) {
        final InputStream request = client.request(url);
        return parser.parse(request, aClass);
    }

    private boolean checkInternetConnection(final Context context) {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;

    }

}
