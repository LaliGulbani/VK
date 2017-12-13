package by.laligulbani.vk.entity.base;


import com.google.gson.annotations.SerializedName;

public class Likes {
    /**
     * Information whether current user likes the photo
     */
    @SerializedName("user_likes")
    private BoolInt userLikes;

    /**
     * Likes number
     */
    @SerializedName("count")
    private Integer count;

    public boolean isUserLikes() {
        return userLikes == BoolInt.YES;
    }

    public Integer getCount() {
        return count;
    }
}
