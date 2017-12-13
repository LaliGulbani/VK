package by.laligulbani.vk.model.db;

import java.util.List;

import by.laligulbani.vk.entity.messages.Message;

public interface IDataBase {
    void saveMessage(Message message);

    List<Message> getMessages();

    Message getLastMessage();

    List<Message> getMessageForId(String id);
}
