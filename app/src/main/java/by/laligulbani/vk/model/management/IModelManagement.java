package by.laligulbani.vk.model.management;


import java.util.Collection;

import by.laligulbani.vk.model.entity.Message;

public interface IModelManagement {

    Collection<Message> getMessages(String token);

    void sendMessages(String token, String message);
}
