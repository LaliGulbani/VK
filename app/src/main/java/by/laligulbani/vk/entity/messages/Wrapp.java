package by.laligulbani.vk.entity.messages;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import static java.util.Collections.emptyList;

public class Wrapp implements Parcelable {

    private final List<Message> messages;

    public Wrapp(List<Message> messages) {
        this.messages = messages;
    }

    protected Wrapp(Parcel in) {
        messages = in.createTypedArrayList(Message.CREATOR);
    }

    public static final Creator<Wrapp> CREATOR = new Creator<Wrapp>() {
        @Override
        public Wrapp createFromParcel(Parcel in) {
            return new Wrapp(in);
        }

        @Override
        public Wrapp[] newArray(int size) {
            return new Wrapp[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(messages);
    }

    public List<Message> getMessages() {
        return (messages == null) ? emptyList() : messages;
    }
}
