package by.laligulbani.vk.presenter.task;

import android.os.AsyncTask;

import java.util.List;

import by.laligulbani.vk.entity.friends.Friends;
import by.laligulbani.vk.model.management.IModelManagement;

public class GetFriendsOnlineTask extends AsyncTask<Void, Void, Void> {

    private final Consumer<List<Friends>> consumer;
    private final IModelManagement modelManager;
    private final String token;

    private List<Friends> friendsOnline;

    public GetFriendsOnlineTask(final IModelManagement modelManager,
                          final String token,
                          final Consumer<List<Friends>> consumer) {
        this.modelManager = modelManager;
        this.consumer = consumer;
        this.token = token;
    }

    @Override
    protected Void doInBackground(final Void... params) {
        this.friendsOnline = modelManager.getFriendsOnline(token);
        return null;
    }

    @Override
    protected void onPostExecute(final Void result) {
        consumer.accept(friendsOnline);
    }
}