package by.laligulbani.vk.model.management;

import java.util.List;

import by.laligulbani.vk.entity.message_list.Message;

public interface IModelManagement {

    List<Message> getMessages(String token);

    void sendMessages(String token, String message);
}
