package by.laligulbani.vk.presenter.task;

import android.os.AsyncTask;

import java.util.List;

import by.laligulbani.vk.entity.message_list.Item;
import by.laligulbani.vk.model.management.IModelManagement;

public class GetMessageTask extends AsyncTask<List<Item>, Integer, List<Item>> {

    private IModelManagement modelManager;
    private Callback mCallbackText;
    private String token;

    public GetMessageTask(IModelManagement modelManager, String token, Callback callbackText) {
        this.modelManager = modelManager;
        mCallbackText = callbackText;
        this.token = token;
    }

    @Override
    protected List<Item> doInBackground(List<Item>[] lists) {
        return modelManager.getMessages(token);
    }

    @Override
    protected void onPostExecute(final List<Item> result) {
        mCallbackText.setText(result);
    }
}