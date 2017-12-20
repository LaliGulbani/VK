package by.laligulbani.vk.model.management;

import java.util.List;

import by.laligulbani.vk.entity.friends.Friends;
import by.laligulbani.vk.entity.messages.Message;

public interface IModelManagement {

    List<Message> getMessages(String token);

    void sendMessages(String token, String message);
    List<Friends> getFriends(String token);

    List<Friends> getFriendsOnline(String token);
}
