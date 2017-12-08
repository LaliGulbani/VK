package by.laligulbani.vk.entity.newsfeed;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.laligulbani.vk.entity.group.GroupFull;
import by.laligulbani.vk.entity.users.UserFull;

public class NewsfeedResponse {
    @SerializedName("items")
    private List<NewsfeedItem> items;

    @SerializedName("profiles")
    private List<UserFull> profiles;

    @SerializedName("groups")
    private List<GroupFull> groups;

    /**
     * New offset value
     */
    @SerializedName("new_offset")
    private String newOffset;

    /**
     * New from value
     */
    @SerializedName("new_from")
    private String newFrom;

    public List<NewsfeedItem> getItems() {
        return items;
    }

    public List<UserFull> getProfiles() {
        return profiles;
    }

    public List<GroupFull> getGroups() {
        return groups;
    }

    public String getNewOffset() {
        return newOffset;
    }

    public String getNewFrom() {
        return newFrom;
    }
}
