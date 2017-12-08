package by.laligulbani.vk.entity.base;


import com.google.gson.annotations.SerializedName;

public class CommentsInfo {
    /**
     * Comments number
     */
    @SerializedName("count")
    private Integer count;

    /**
     * Information whether current user can comment the post
     */
    @SerializedName("can_post")
    private Integer canPost;

    public Integer getCount() {
        return count;
    }

    public Integer getCanPost() {
        return canPost;
    }
}
