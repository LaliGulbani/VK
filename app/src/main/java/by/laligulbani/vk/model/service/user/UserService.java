package by.laligulbani.vk.model.service.user;

import android.content.Context;

import java.util.List;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.entity.friends.Friends;
import by.laligulbani.vk.entity.friends.FriendsResponse;
import by.laligulbani.vk.entity.users.User;
import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.parser.IParser;
import by.laligulbani.vk.model.service.AbstractService;

public class UserService extends AbstractService implements IUserService {

    UserService(final Context context,
                final IClient client,
                final IParser parser) {
        super(context, parser, client);
    }

    @Override
    public List<Friends> getFriends(final String token) {
        final String url = Api.FRIENDS_GET;
        return execute(url, FriendsResponse.class).getFriends();
    }

    @Override
    public List<Friends> getFriendsOnline(String token) {
        final String url = Api.FRIENDS_ONLINE;
        return execute(url, FriendsResponse.class).getFriends();
    }

    @Override
    public User getUser(final String id) {

        final User user = new User();
        user.setLastName("Last name");
        user.setFirstName("First name");

        return user;
    }
}

