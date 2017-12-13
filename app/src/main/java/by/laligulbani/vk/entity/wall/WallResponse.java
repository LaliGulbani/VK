package by.laligulbani.vk.entity.wall;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WallResponse {
    /**
     * Total number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<WallPostFull> items;

    public Integer getCount() {
        return count;
    }

    public List<WallPostFull> getItems() {
        return items;
    }
}
