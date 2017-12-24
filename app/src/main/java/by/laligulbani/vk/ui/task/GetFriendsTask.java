package by.laligulbani.vk.ui.task;

import android.os.AsyncTask;

import java.util.List;

import by.laligulbani.vk.entity.friends.Friends;
import by.laligulbani.vk.model.function.Consumer;
import by.laligulbani.vk.model.service.dialog.IDialogService;

public class GetFriendsTask extends AsyncTask<Void, Void, Void> {

    private final Consumer<List<Friends>> consumer;
    private final IDialogService modelManager;
    private final String token;

    private List<Friends> friends;

    public GetFriendsTask(final IDialogService modelManager,
                          final String token,
                          final Consumer<List<Friends>> consumer) {
        this.modelManager = modelManager;
        this.consumer = consumer;
        this.token = token;
    }

    @Override
    protected Void doInBackground(final Void... params) {
//        this.friends = modelManager.getFriends(token);
        return null;
    }

    @Override
    protected void onPostExecute(final Void result) {
        consumer.accept(friends);
    }
}