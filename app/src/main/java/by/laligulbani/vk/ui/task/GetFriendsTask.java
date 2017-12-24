package by.laligulbani.vk.ui.task;

import android.os.AsyncTask;

import java.util.List;

import by.laligulbani.vk.entity.friends.Friends;
import by.laligulbani.vk.model.function.Consumer;
import by.laligulbani.vk.model.service.user.IUserService;

public class GetFriendsTask extends AsyncTask<Void, Void, Void> {

    private final Consumer<List<Friends>> consumer;
    private final IUserService userService;
    private final String token;

    private List<Friends> friends;

    public GetFriendsTask(final IUserService userService,
                          final String token,
                          final Consumer<List<Friends>> consumer) {
        this.userService = userService;
        this.consumer = consumer;
        this.token = token;
    }

    @Override
    protected Void doInBackground(final Void... params) {
        this.friends = userService.getFriends(token);
        return null;
    }

    @Override
    protected void onPostExecute(final Void result) {
        consumer.accept(friends);
    }
}