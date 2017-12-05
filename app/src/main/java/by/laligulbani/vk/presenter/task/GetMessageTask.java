package by.laligulbani.vk.presenter.task;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.List;
import java.util.function.Consumer;

import by.laligulbani.vk.entity.message_list.Message;
import by.laligulbani.vk.model.management.IModelManagement;

public class GetMessageTask extends AsyncTask<List<Message>, Integer, List<Message>> {

    private IModelManagement modelManager;
    private Consumer<List<Message>> consumer;
    private String token;

    public GetMessageTask(IModelManagement modelManager, String token, Consumer<List<Message>> callbackText) {
        this.modelManager = modelManager;
        this.consumer = callbackText;
        this.token = token;
    }

    @Override
    protected List<Message> doInBackground(List<Message>[] lists) {
        return modelManager.getMessages(token);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onPostExecute(final List<Message> messages) {
        consumer.accept(messages);
    }
}