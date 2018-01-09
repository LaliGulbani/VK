package by.laligulbani.vk.entity.dialog;

import com.google.gson.annotations.SerializedName;

public class Dialog {

//    @SerializedName("uid") // идентификатор сообщения
    private String uid;
//    @SerializedName("date") //дата отправки сообщения в формате Unixtime.
    private String date;
//    @SerializedName("body") // текст сообщения.
    private String body;
//    @SerializedName("title") //заголовок сообщения или беседы.
    private String title;
//    @SerializedName("title") //заголовок сообщения или беседы.
    private String image;

    private String photo_50;

    public String getPhoto_50() {
        return photo_50;
    }

    public void setPhoto_50(String photo_50) {
        this.photo_50 = photo_50;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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
