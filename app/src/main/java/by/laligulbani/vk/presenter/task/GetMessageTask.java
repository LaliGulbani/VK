package by.laligulbani.vk.presenter.task;

import android.os.AsyncTask;

import java.util.List;

import by.laligulbani.vk.entity.message_list.Item;
import by.laligulbani.vk.model.management.IModelManagement;

public class GetMessageTask extends AsyncTask<String, Integer, String> {

    private IModelManagement modelManager;
    private String token;
    private Callback mCallbackText;

    public GetMessageTask(IModelManagement modelManager, String token, Callback callbackText) {
        this.modelManager = modelManager;
        this.token = token;
        mCallbackText = callbackText;
    }

    @Override
    protected String doInBackground(final String[] tokens) {

        final List<Item> items = modelManager.getMessages(token);
        final StringBuilder sb = new StringBuilder();
        for (final Item item : items) {
            sb.append(item.body);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(final String result) {
       // mCallbackText.setText();

    }
}