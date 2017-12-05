package by.laligulbani.vk.entity.friends_list;


import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class FriendsList {
    @SerializedName("name")
    private String name;

    //List ID

    @SerializedName("id")
    private Integer id;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendsList friendsList = (FriendsList) o;
        return Objects.equals(name, friendsList.name) &&
                Objects.equals(id, friendsList.id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FriendsList{");
        sb.append("name='").append(name).append("'");
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
