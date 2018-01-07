package by.laligulbani.vk.model.parser.wrappers;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.laligulbani.vk.entity.wall.WallPostFull;

public class WallResponse {

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
