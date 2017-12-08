package by.laligulbani.vk.entity.base;

import com.google.gson.annotations.SerializedName;

public class LikesInfo {
    /**
     * Likes number
     */
    @SerializedName("count")
    private Integer count;

    /**
     * Information whether current uer has liked the post
     */
    @SerializedName("user_likes")
    private Integer userLikes;

    /**
     * Information whether current user can like the post
     */
    @SerializedName("can_like")
    private Integer canLike;

    /**
     * Information whether current user can repost
     */
    @SerializedName("can_publish")
    private Integer canPublish;

    public Integer getCount() {
        return count;
    }

    public Integer getUserLikes() {
        return userLikes;
    }

    public Integer getCanLike() {
        return canLike;
    }

    public Integer getCanPublish() {
        return canPublish;
    }

}
