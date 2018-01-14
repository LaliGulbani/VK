package by.laligulbani.vk.model.parser.wrappers;

import java.util.List;

import by.laligulbani.vk.entity.message.MessageHistory;

public class MessageResponse {

    private List<MessageHistory> mMessageHistory;

    public List<MessageHistory> getMessageHistory() {
        return mMessageHistory;
    }

    public void setMessageHistory(List<MessageHistory> messageHistory) {
        this.mMessageHistory = messageHistory;
    }
}
