package by.laligulbani.vk.entity.friends;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FriendsResponse {

    @SerializedName("response")
    private List<String> friendsId;

    public List<String> getFriends() {
        return friendsId;
    }
}
