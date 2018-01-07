package by.laligulbani.vk.model.parser.wrappers;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.laligulbani.vk.entity.dialog.Dialog;

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
