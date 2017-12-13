package by.laligulbani.vk.entity.wall;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.laligulbani.vk.entity.base.CommentsInfo;
import by.laligulbani.vk.entity.base.LikesInfo;
import by.laligulbani.vk.entity.base.RepostsInfo;

public class WallPostFull extends WallPost {
    @SerializedName("copy_history")
    private List<WallPost> copyHistory;

    /**
     * Information whether current user can edit the post
     */
    @SerializedName("can_edit")
    private Integer canEdit;

    /**
     * Post creator ID (if post still can be edited)
     */
    @SerializedName("created_by")
    private Integer createdBy;

    /**
     * Information whether current user can delete the post
     */
    @SerializedName("can_delete")
    private Integer canDelete;

    /**
     * Information whether current user can pin the post
     */
    @SerializedName("can_pin")
    private Integer canPin;

    /**
     * Information whether the post is pinned
     */
    @SerializedName("is_pinned")
    private Integer isPinned;

    @SerializedName("comments")
    private CommentsInfo comments;

    @SerializedName("likes")
    private LikesInfo likes;

    @SerializedName("reposts")
    private RepostsInfo reposts;

    public List<WallPost> getCopyHistory() {
        return copyHistory;
    }

    public Integer getCanEdit() {
        return canEdit;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Integer getCanDelete() {
        return canDelete;
    }

    public Integer getCanPin() {
        return canPin;
    }

    public Integer getIsPinned() {
        return isPinned;
    }

    public CommentsInfo getComments() {
        return comments;
    }

    public LikesInfo getLikes() {
        return likes;
    }

    public RepostsInfo getReposts() {
        return reposts;
    }

}
