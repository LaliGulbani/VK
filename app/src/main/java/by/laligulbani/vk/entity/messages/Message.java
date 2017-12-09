package by.laligulbani.vk.entity.messages;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Message implements Parcelable {

    @SerializedName("uid") // идентификатор сообщения
    private Integer id;
    @SerializedName("date") //дата отправки сообщения в формате Unixtime.
    public String date;
    @SerializedName("out")
    // тип сообщения (0 — полученное, 1 — отправленное, не возвращается для пересланных сообщений).
    private Integer out;
    @SerializedName("read_state")
    // статус сообщения (0 — не прочитано, 1 — прочитано, не возвращается для пересланных сообщений).
    private Integer read_state;
    @SerializedName("title") //заголовок сообщения или беседы.
    public String title;
    @SerializedName("body") // текст сообщения.
    private String body;

    protected Message(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            out = null;
        } else {
            out = in.readInt();
        }
        if (in.readByte() == 0) {
            read_state = null;
        } else {
            read_state = in.readInt();
        }
        title = in.readString();
        body = in.readString();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOut() {
        return out;
    }

    public void setOut(Integer out) {
        this.out = out;
    }

    public Integer getRead_state() {
        return read_state;
    }

    public void setRead_state(Integer read_state) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        if (out == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(out);
        }
        if (read_state == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(read_state);
        }
        dest.writeString(title);
        dest.writeString(body);
    }
}
