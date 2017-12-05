package by.laligulbani.vk.model.management;

import java.util.List;

import by.laligulbani.vk.entity.message_list.Item;

public interface IModelManagement {

    List<Item> getMessages(String token);

    void sendMessages(String token, String message);
}
