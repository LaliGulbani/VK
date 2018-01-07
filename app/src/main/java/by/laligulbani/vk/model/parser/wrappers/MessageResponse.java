package by.laligulbani.vk.model.parser.wrappers;

import java.util.List;

import by.laligulbani.vk.entity.message.Message;

public class MessageResponse {

    private List<Message> message;

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
