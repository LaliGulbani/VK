package by.laligulbani.vk.model.service.user;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.entity.friends.Friends;
import by.laligulbani.vk.entity.friends.FriendsResponse;
import by.laligulbani.vk.entity.users.User;
import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.db.IDataBase;
import by.laligulbani.vk.model.parser.IParser;
import by.laligulbani.vk.model.service.AbstractService;

public class UserService extends AbstractService implements IUserService {

    private final IDataBase dataBase;

    UserService(final Context context,
                final IClient client,
                final IParser parser,
                final IDataBase dataBase) {
        super(context, parser, client);
        this.dataBase = dataBase;
    }

    @Override
    public List<Friends> getFriends(final String token) {

        if (checkInternetConnection()) {

            final String getFriendsAmountUrl = "https://api.vk.com/method/friends.get?user_id=";

            final Long actualAmount = execute(getFriendsAmountUrl, Long.class);
            final Long dbAmount = dataBase.getFriendsAmount();

            if (!dbAmount.equals(actualAmount)) {

                final String getFriendsUrl = "https://api.vk.com/method/friends.get?user_id=";

                final List<Friends> dialogs = execute(getFriendsUrl, FriendsResponse.class).getFriends();
                dataBase.addFriends(dialogs);
            }
        }

        return dataBase.getFriends();
    }

    @Override
    public List<User> getFriendsOnline(String token) {

        final String url = Api.FRIENDS_ONLINE;
        final List<String> ids = execute(url, List.class);

        final List<User> friends = new ArrayList<>();
        for (final String id : ids) {
            friends.add(getUser(id));
        }

        return friends;
    }

    @Override
    public User getUser(final String id) {

        final User dbUser = dataBase.getUser(id);

        if (dbUser == null) {
            final String getUserInfoUrl = "https://api.vk.com/method/friends.get?user_id=";
            final User user = execute(getUserInfoUrl, User.class);
            dataBase.addUser(user);
            return user;
        }

        final User user = new User();
        user.setLastName("Last name");
        user.setFirstName("First name");

        return user;
    }
}

