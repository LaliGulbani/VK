package by.laligulbani.vk.entity.friends;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FriendsResponse {
    /**
     * Total communities number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<FriendsList> items;

    public Integer getCount() {
        return count;
    }

    public List<FriendsList> getItems() {
        return items;
    }
}
