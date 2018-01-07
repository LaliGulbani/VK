package by.laligulbani.vk.model.parser.wrappers;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.laligulbani.vk.entity.users.UserFull;

public class UserFullResponse {

    @SerializedName("response")
    private List<UserFull> users;

    public List<UserFull> getUsers() {
        return users;
    }
}
