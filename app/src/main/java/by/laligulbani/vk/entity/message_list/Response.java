package by.laligulbani.vk.entity.message_list;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    @SerializedName("count")
    private long count;
    @SerializedName("items")
    public List<Item> items;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
