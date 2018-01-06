package by.laligulbani.vk.entity.dialog;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DialogResponse {

    @SerializedName("count")
    private String count;
    @SerializedName("items")
    private List<Dialog> mDialogs;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<Dialog> getDialogs() {
        return mDialogs;
    }

    public void setMessages(List<Dialog> dialogs) {
        this.mDialogs = dialogs;
    }

}
