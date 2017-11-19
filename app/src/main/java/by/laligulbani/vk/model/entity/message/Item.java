package by.laligulbani.vk.model.entity.message;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Item {
    @SerializedName("id")
    public long id;
    @SerializedName("date")
    public Date date;
    @SerializedName("out")
    public long out;
    @SerializedName("user_id")
    public long user_id;
    @SerializedName("read_state")
    public long read_state;
    @SerializedName("title")
    public String title;
    @SerializedName("body")
    public String body;
}
