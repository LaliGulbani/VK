package by.laligulbani.vk.entity.messages;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Message implements Parcelable {


    @SerializedName("user_id") // идентификатор пользователя, в диалоге с которым находится сообщение.
    public Long user_id;
    @SerializedName("from_id") // идентификатор автора сообщения
    public Long from_id;
    @SerializedName("id") // идентификатор сообщения
    public Long id;
    @SerializedName("date") //дата отправки сообщения в формате Unixtime.
    public Date date;
    @SerializedName("out") // тип сообщения (0 — полученное, 1 — отправленное, не возвращается для пересланных сообщений).
    public Long out;
    @SerializedName("read_state") // статус сообщения (0 — не прочитано, 1 — прочитано, не возвращается для пересланных сообщений).
    public Long read_state;
    @SerializedName("title") //заголовок сообщения или беседы.
    public String title;
    @SerializedName("body") // текст сообщения.
    public String body;

    protected Message(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        if (in.readByte() == 0) {
            out = null;
        } else {
            out = in.readLong();
        }
        if (in.readByte() == 0) {
            user_id = null;
        } else {
            user_id = in.readLong();
        }
        if (in.readByte() == 0) {
            read_state = null;
        } else {
            read_state = in.readLong();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getFrom_id() {
        return from_id;
    }

    public void setFrom_id(Long from_id) {
        this.from_id = from_id;
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
