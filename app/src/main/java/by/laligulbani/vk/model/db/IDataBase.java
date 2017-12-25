package by.laligulbani.vk.model.db;

import java.util.Collection;
import java.util.List;

import by.laligulbani.vk.entity.friends.Friends;
import by.laligulbani.vk.entity.messages.Dialog;
import by.laligulbani.vk.entity.users.User;

public interface IDataBase {

    void addDialog(Dialog dialog);

    void addDialogs(Collection<Dialog> dialogs);

    List<Dialog> getDialogs();

    Dialog getLastDialog();

    Dialog getDialogById(int id);

    Long getDialogCount();

    void addFriends(Collection<Friends> dialogs);

    List<Friends> getFriends();

    Long getFriendsAmount();

    User getUser(String id);

    void addUser(User user);
}
