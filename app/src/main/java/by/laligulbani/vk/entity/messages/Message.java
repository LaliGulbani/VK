package by.laligulbani.vk.entity.messages;

import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("user_id") // идентификатор сообщения
    private String id;
    @SerializedName("date") //дата отправки сообщения в формате Unixtime.
    public String date;
    @SerializedName("out")
    // тип сообщения (0 — полученное, 1 — отправленное, не возвращается для пересланных сообщений).
    private String out;
    @SerializedName("read_state")
    // статус сообщения (0 — не прочитано, 1 — прочитано, не возвращается для пересланных сообщений).
    private String read_state;
    @SerializedName("title") //заголовок сообщения или беседы.
    public String title;
    @SerializedName("body") // текст сообщения.
    private String body;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public String getRead_state() {
        return read_state;
    }

    public void setRead_state(String read_state) {
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
