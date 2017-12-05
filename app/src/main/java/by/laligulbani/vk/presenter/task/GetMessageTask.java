package by.laligulbani.vk.presenter.task;

import android.os.AsyncTask;

import java.util.List;

import by.laligulbani.vk.entity.message_list.Message;
import by.laligulbani.vk.model.management.IModelManagement;

public class GetMessageTask extends AsyncTask<List<Message>, Integer, List<Message>> {

    private IModelManagement modelManager;
    private Callback mCallbackText;
    private String token;

    public GetMessageTask(IModelManagement modelManager, String token, Callback callbackText) {
        this.modelManager = modelManager;
        mCallbackText = callbackText;
        this.token = token;
    }

    @Override
    protected List<Message> doInBackground(List<Message>[] lists) {
        return modelManager.getMessages(token);
    }

    @Override
    protected void onPostExecute(final List<Message> result) {
        mCallbackText.setText(result);
    }
}