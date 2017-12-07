package by.laligulbani.vk.entity.photo;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotoResponse {
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<Photo> items;

    public Integer getCount() {
        return count;
    }

    public List<Photo> getItems() {
        return items;
    }

}
