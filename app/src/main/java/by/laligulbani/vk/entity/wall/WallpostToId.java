package by.laligulbani.vk.entity.wall;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.laligulbani.vk.entity.base.CommentsInfo;
import by.laligulbani.vk.entity.base.Geo;
import by.laligulbani.vk.entity.base.LikesInfo;
import by.laligulbani.vk.entity.base.RepostsInfo;

public class WallpostToId {

    /**
     * Post ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Post author ID
     */
    @SerializedName("from_id")
    private Integer fromId;

    /**
     * Wall owner's ID
     */
    @SerializedName("to_id")
    private Integer toId;

    /**
     * Date of publishing in Unixtime
     */
    @SerializedName("date")
    private Integer date;

    /**
     * wall post ID (if comment)
     */
    @SerializedName("post_id")
    private Integer postId;

    @SerializedName("post_type")
    private PostType postType;

    /**
     * Post text
     */
    @SerializedName("text")
    private String text;

    /**
     * Post signer ID
     */
    @SerializedName("signer_id")
    private Integer signerId;

    @SerializedName("attachments")
    private List<WallpostAttachment> attachments;

    @SerializedName("geo")
    private Geo geo;

    @SerializedName("post_source")
    private PostSource postSource;

    @SerializedName("comments")
    private CommentsInfo comments;

    @SerializedName("likes")
    private LikesInfo likes;

    @SerializedName("reposts")
    private RepostsInfo reposts;

    /**
     * ID of the source post owner
     */
    @SerializedName("copy_owner_id")
    private Integer copyOwnerId;

    /**
     * ID of the source post
     */
    @SerializedName("copy_post_id")
    private Integer copyPostId;

    public Integer getId() {
        return id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public Integer getDate() {
        return date;
    }

    public Integer getPostId() {
        return postId;
    }

    public PostType getPostType() {
        return postType;
    }

    public String getText() {
        return text;
    }

    public Integer getSignerId() {
        return signerId;
    }

    public List<WallpostAttachment> getAttachments() {
        return attachments;
    }

    public Geo getGeo() {
        return geo;
    }

    public PostSource getPostSource() {
        return postSource;
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

    public Integer getCopyOwnerId() {
        return copyOwnerId;
    }

    public Integer getCopyPostId() {
        return copyPostId;
    }
}
