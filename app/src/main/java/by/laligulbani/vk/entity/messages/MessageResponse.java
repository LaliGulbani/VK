package by.laligulbani.vk.entity.messages;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MessageResponse {

    @SerializedName("count")
    private long count;
    @SerializedName("items")
    private List<Message> mMessages;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<Message> getMessages() {
        return mMessages;
    }

    public void setMessages(List<Message> messages) {
        this.mMessages = messages;
    }

}
