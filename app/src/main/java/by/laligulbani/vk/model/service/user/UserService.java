package by.laligulbani.vk.model.service.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.entity.friends.FriendsResponse;
import by.laligulbani.vk.entity.users.UserFull;
import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.db.IDataBase;
import by.laligulbani.vk.model.parser.IParser;
import by.laligulbani.vk.model.service.AbstractService;
import by.laligulbani.vk.model.service.executor.IExecutorService;

public class UserService extends AbstractService implements IUserService {

    private final IExecutorService executorService;
    private final IDataBase dataBase;

    UserService(final IClient client,
                final IParser parser,
                final IDataBase dataBase,
                final IExecutorService executorService) {
        super(parser, client);
        this.dataBase = dataBase;
        this.executorService = executorService;
    }

    @Override
    public List<UserFull> getFriends(final String token) {

        if (checkInternetConnection()) {
            final String friendsUrl = Api.FRIENDS_GET_ID + getUserId() + "&" + "access_token=" + token;
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
    public UserFull getUser(final String id) {

        final UserFull dbUser = dataBase.getUser(id);

        if (dbUser == null) {
            final String getUserInfoUrl = Api.USERS_GET + id;
            final UserFull user = execute(getUserInfoUrl, UserFull.class);
            dataBase.addUser(user);
            return user;
        }

        return dbUser;
    }

    @Override
    public List<UserFull> getUsers(final Collection<String> ids) {

        final List<UserFull> users = new ArrayList<>();

        final List<Runnable> tasks = new ArrayList<>();
        for (final String id : ids) {
            tasks.add(() -> {
                final UserFull user = getUser(id);
                synchronized (this) {
                    users.add(user);
                }
            });
        }

        executorService.invokeAll(tasks);

        return users;
    }
}

