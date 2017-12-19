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
    private List<Friends> items;

    public Integer getCount() {
        return count;
    }

    public List<Friends> getItems() {
        return items;
    }
}
