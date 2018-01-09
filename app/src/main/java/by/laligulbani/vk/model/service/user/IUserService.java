package by.laligulbani.vk.model.service.user;

import java.util.Collection;
import java.util.List;

import by.laligulbani.vk.entity.users.UserFull;

public interface IUserService {

    List<UserFull> getFriends(String token);

    List<UserFull> getFriendsOnline(String token);

    UserFull getMainUser(String token);

    UserFull getUser(String id);

    List<UserFull> getUsers(Collection<String> ids);
}

