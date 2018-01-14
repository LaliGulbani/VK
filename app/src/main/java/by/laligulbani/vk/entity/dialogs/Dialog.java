package by.laligulbani.vk.entity.dialogs;

import com.google.gson.annotations.SerializedName;

public class Dialog {

    @SerializedName("uid") // идентификатор пользователя id
    private String id;
    @SerializedName("date") //дата отправки сообщения в формате Unixtime.
    private String date;
    @SerializedName("body") // текст сообщения.
    private String body;

    private String image;

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
