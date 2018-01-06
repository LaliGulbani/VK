package by.laligulbani.vk.entity.dialog;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ItemMessage {

    @SerializedName("id")
    private long id;
    @SerializedName("date")
    private Date date;
    @SerializedName("out")
    private long out;
    @SerializedName("user_id")
    private long user_id;
    @SerializedName("read_state")
    private long read_state;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getOut() {
        return out;
    }

    public void setOut(long out) {
        this.out = out;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getRead_state() {
        return read_state;
    }

    public void setRead_state(long read_state) {
        this.read_state = read_state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
