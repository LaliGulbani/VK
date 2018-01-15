package by.laligulbani.vk.model.service.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.entity.users.UserFull;
import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.db.IDataBase;
import by.laligulbani.vk.model.parser.IParser;
import by.laligulbani.vk.model.parser.wrappers.FriendsResponse;
import by.laligulbani.vk.model.parser.wrappers.UserFullResponse;
import by.laligulbani.vk.model.service.AbstractService;

import static java.util.Collections.emptyList;

public class UserService extends AbstractService implements IUserService {

    private final IDataBase dataBase;

    UserService(final IClient client,
                final IParser parser,
                final IDataBase dataBase) {
        super(parser, client);
        this.dataBase = dataBase;
    }

    @Override
    public List<UserFull> getFriends(final String token) {

        if (checkInternetConnection()) {
          String friendsUrl = Api.FRIENDS_GET_ID + getUserId() + "&" + "access_token=" + token;
           /* final String friendsUrl = new Api.Builder()
                    .basePathMethod("https://api.vk.com/method/")
                    .nameMethod("friends.get")
                    .addParameter("user_id", getUserId())
                    .addParameterToken(token)
                    .build();*/
            return getUsers(execute(friendsUrl, FriendsResponse.class).getFriends());
        }

        return dataBase.getFriends();
    }

    @Override
    public List<UserFull> getFriendsOnline(final String token) {
        final String friendsOnlineUrl = Api.FRIENDS_ONLINE + token;
        return getUsers(execute(friendsOnlineUrl, FriendsResponse.class).getFriends());
    }

    @Override
    public UserFull getMainUser(final String token) {
        final String mainUserUrl = Api.USERS_GET + getUserId() + "&" + "access_token=" + token;
       /* final String mainUserUrl = new Api.Builder()
                .basePathMethod("https://api.vk.com/method/")
                .nameMethod("users.get")
                .addParameterToken(token)
                .addParameter("fields", "photo_50")
                .addParameter("user_ids", getUserId())
                .build();*/
        return execute(mainUserUrl, UserFullResponse.class).getUsers().get(0);
    }

    @Override
    public UserFull getUser(final String id) {

        final UserFull dbUser = dataBase.getUser(id);

        if (dbUser == null && checkInternetConnection()) {
            synchronized (this) {

                final UserFull checkUser = dataBase.getUser(id);

                if (checkUser != null) {
                    return checkUser;
                }

                final String getUserInfoUrl = Api.USERS_GET + id;

                final List<UserFull> response = execute(getUserInfoUrl, UserFullResponse.class).getUsers();

                if (response == null || response.isEmpty()) {
                    return null;
                }

                final UserFull user = response.get(0);
                dataBase.addUser(user);
                return user;
            }
        }

        return dbUser;
    }

    @Override
    public List<UserFull> getUsers(final Collection<String> ids) {

        if (ids == null || ids.isEmpty()) {
            return emptyList();
        }

        final List<UserFull> users = new ArrayList<>();
        for (final String id : ids) {
            users.add(getUser(id));
        }
        return users;
    }
}

