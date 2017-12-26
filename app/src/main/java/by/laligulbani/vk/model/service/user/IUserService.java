package by.laligulbani.vk.model.service.user;

import java.util.List;

import by.laligulbani.vk.entity.users.User;
import by.laligulbani.vk.entity.users.UserFull;

public interface IUserService {

    List<UserFull> getFriends(String token);

    List<User> getFriendsOnline(String token);

    User getUser(String id);
}

