package by.laligulbani.vk.model.service.user;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.entity.friends.FriendsResponse;
import by.laligulbani.vk.entity.users.User;
import by.laligulbani.vk.entity.users.UserFull;
import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.db.IDataBase;
import by.laligulbani.vk.model.parser.IParser;
import by.laligulbani.vk.model.service.AbstractService;
import by.laligulbani.vk.model.util.ContextHolder;

import static by.laligulbani.vk.Api.EMPTY;
import static by.laligulbani.vk.ui.activity.LoginActivity.APP_PREFERENCES_NAME;
import static by.laligulbani.vk.ui.activity.LoginActivity.PREFERENCES_ID_USER;

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
    public List<UserFull> getFriends(final String token) {
        final String id_user = context.getSharedPreferences(APP_PREFERENCES_NAME, 0)
                .getString(PREFERENCES_ID_USER, EMPTY);

        if (checkInternetConnection()) {

            // final String getFriendsAmountUrl = "https://api.vk.com/method/friends.get?user_id=";

            // final Long actualAmount = execute(getFriendsAmountUrl, Long.class);
            // final Long dbAmount = dataBase.getFriendsAmount();

            //if (!dbAmount.equals(actualAmount)) {

            final String getFriendsUrl = Api.FRIENDS_GET_ID + id_user;

            final List<String> friendsIds = execute(getFriendsUrl, FriendsResponse.class).getFriends();

            final List<UserFull> users = new ArrayList<>();
            for (final String id : friendsIds) {
                final UserFull user = getUser(id);
                if (user != null) {
                    users.add(user);
                }
            }

            return users;
            // dataBase.addFriends(friendsIds);
        }
        //  }

        return dataBase.getUsers();
    }

    @Override
    public List<UserFull> getFriendsOnline(String token) {
        final Context context = ContextHolder.getContext();
        final String id_user = context.getSharedPreferences(APP_PREFERENCES_NAME, 0)
                .getString(PREFERENCES_ID_USER, EMPTY);

        final String url = Api.FRIENDS_ONLINE + id_user;
        final List<String> ids = execute(url, List.class);

        final List<UserFull> friends = new ArrayList<>();
        for (final String id : ids) {
            friends.add(getUser(id));
        }

        return friends;
    }

    @Override
    public UserFull getUser(final String id) {

        final User dbUser = dataBase.getUser(id);

        if (dbUser == null) {
            final String getUserInfoUrl = Api.USERS_GET + id;
            final UserFull user = execute(getUserInfoUrl, UserFull.class);
            dataBase.addUser(user);
            return user;
        }

        final UserFull user = new UserFull();
        user.setLastName("Last name");
        user.setFirstName("First name");

        return user;
    }
}

