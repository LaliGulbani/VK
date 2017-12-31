package by.laligulbani.vk.model.db;

import java.util.Collection;
import java.util.List;

import by.laligulbani.vk.entity.messages.Message;

public interface IMessageDataBase {

    void addMessage(Message message);

    void addMessages(Collection<Message> message);

    List<Message> getMessages();

    Message getLastMessage();

    Message getMessageForId(int id);
}
