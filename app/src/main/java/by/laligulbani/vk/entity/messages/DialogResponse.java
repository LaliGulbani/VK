package by.laligulbani.vk.entity.messages;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DialogResponse {

    @SerializedName("count")
    private long count;
    @SerializedName("items")
    private List<Dialog> mDialogs;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<Dialog> getDialogs() {
        return mDialogs;
    }

    public void setMessages(List<Dialog> dialogs) {
        this.mDialogs = dialogs;
    }

}
