package by.laligulbani.vk.entity.message_list;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    @SerializedName("count")
    private long count;
    @SerializedName("items")
    public List<Message> mMessages;

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
