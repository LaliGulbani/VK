package by.laligulbani.vk.entity.friends;

import com.google.gson.annotations.SerializedName;

public class FriendsList {
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
