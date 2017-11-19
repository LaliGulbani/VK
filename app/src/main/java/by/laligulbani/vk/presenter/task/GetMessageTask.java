package by.laligulbani.vk.presenter.task;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.List;

import by.laligulbani.vk.model.entity.message.Item;
import by.laligulbani.vk.model.management.IModelManagement;

public class GetMessageTask extends AsyncTask<String, Integer, String> {

    private IModelManagement modelManager;
    private String token;
    private TextView textView;

    public GetMessageTask(IModelManagement modelManager, String token, TextView textView) {
        this.modelManager = modelManager;
        this.token = token;
        this.textView = textView;
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
        textView.setText(result);
    }
}