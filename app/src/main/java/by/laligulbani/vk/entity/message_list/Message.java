package by.laligulbani.vk.entity.message_list;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Message {

    @SerializedName("id")
    public Long id;
    @SerializedName("date")
    public Date date;
    @SerializedName("out")
    public Long out;
    @SerializedName("user_id")
    public Long user_id;
    @SerializedName("read_state")
    public Long read_state;
    @SerializedName("title")
    public String title;
    @SerializedName("body")
    public String body;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getOut() {
        return out;
    }

    public void setOut(Long out) {
        this.out = out;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getRead_state() {
        return read_state;
    }

    public void setRead_state(Long read_state) {
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
