package by.laligulbani.vk.entity.messages;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Message implements Parcelable {


    @SerializedName("user_id") // идентификатор пользователя, в диалоге с которым находится сообщение.
    private Integer user_id;
    @SerializedName("from_id") // идентификатор автора сообщения
    private Integer from_id;
    @SerializedName("id") // идентификатор сообщения
    private Integer id;
    @SerializedName("date") //дата отправки сообщения в формате Unixtime.
    public Date date;
    @SerializedName("out") // тип сообщения (0 — полученное, 1 — отправленное, не возвращается для пересланных сообщений).
    private Integer out;
    @SerializedName("read_state") // статус сообщения (0 — не прочитано, 1 — прочитано, не возвращается для пересланных сообщений).
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
            user_id = null;
        } else {
            user_id = in.readInt();
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getFrom_id() {
        return from_id;
    }

    public void setFrom_id(Integer from_id) {
        this.from_id = from_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getOut() {
        return out;
    }

    public void setOut(Integer out) {
        this.out = out;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
        if (user_id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(user_id);
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
