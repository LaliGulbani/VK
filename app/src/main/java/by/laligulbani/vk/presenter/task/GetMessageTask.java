package by.laligulbani.vk.presenter.task;

import android.os.AsyncTask;

import java.util.List;

import by.laligulbani.vk.entity.messages.Message;
import by.laligulbani.vk.model.management.IModelManagement;

public class GetMessageTask extends AsyncTask<Void, Void, Void> {

    private final Consumer<List<Message>> consumer;
    private final IModelManagement modelManager;
    private final String token;

    private List<Message> messages;

    public GetMessageTask(final IModelManagement modelManager,
                          final String token,
                          final Consumer<List<Message>> consumer) {
        this.modelManager = modelManager;
        this.consumer = consumer;
        this.token = token;
    }

    @Override
    protected Void doInBackground(final Void... params) {
        this.messages = modelManager.getMessages(token);
        return null;
    }

    @Override
    protected void onPostExecute(final Void result) {
        consumer.accept(messages);
    }
}