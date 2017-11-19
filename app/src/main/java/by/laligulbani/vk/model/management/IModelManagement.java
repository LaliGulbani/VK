package by.laligulbani.vk.model.management;


import java.util.List;

import by.laligulbani.vk.model.entity.message.Item;

public interface IModelManagement {

    List<Item> getMessages(String token);

    void sendMessages(String token, String message);
}
