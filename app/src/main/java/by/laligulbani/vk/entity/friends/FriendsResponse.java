package by.laligulbani.vk.entity.friends;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FriendsResponse {

    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<Friends> friends;

    public Integer getCount() {
        return count;
    }

    public List<Friends> getFriends() {
        return friends;
    }
}
