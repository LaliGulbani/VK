package by.laligulbani.vk.entity.message;

import java.util.List;

public class MessageResponseServer {
    public List<NewMessage> getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(List<NewMessage> newMessage) {
        this.newMessage = newMessage;
    }

    List<NewMessage> newMessage;
}
