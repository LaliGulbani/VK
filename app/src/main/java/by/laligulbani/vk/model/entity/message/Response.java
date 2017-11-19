package by.laligulbani.vk.model.entity.message;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.laligulbani.vk.model.entity.Item;

public class Response {
    @SerializedName("count")
    public long count;
    @SerializedName("items")
    public List<Item> items;
}
