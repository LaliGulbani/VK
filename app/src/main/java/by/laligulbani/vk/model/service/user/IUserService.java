package by.laligulbani.vk.model.service.user;

import java.util.List;

import by.laligulbani.vk.entity.friends.Friends;
import by.laligulbani.vk.entity.users.User;

public interface IUserService {

    List<Friends> getFriends(String token);

    List<Friends> getFriendsOnline(String token);

    User getUser(String id);
}
