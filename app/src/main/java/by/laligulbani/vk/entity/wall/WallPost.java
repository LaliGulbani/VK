package by.laligulbani.vk.entity.wall;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.laligulbani.vk.entity.base.Geo;

public class WallPost {
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
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Date of publishing in Unixtime
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Count of views
     */
    @SerializedName("views")
    private Views views;


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

    public Integer getId() {
        return id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public Integer getDate() {
        return date;
    }

    public Views getViews() {
        return views;
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
}
