package by.laligulbani.vk.entity.wall;


import com.google.gson.annotations.SerializedName;

public class AttachedNote {
    /**
     * Note ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Note owner's ID
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Comments number
     */
    @SerializedName("comments")
    private Integer comments;

    /**
     * Read comments number
     */
    @SerializedName("read_comments")
    private Integer readComments;

    /**
     * Date when the note has been created in Unixtime
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Note title
     */
    @SerializedName("title")
    private String title;

    /**
     * URL of the page with note preview
     */
    @SerializedName("view_url")
    private String viewUrl;

    public Integer getId() {
        return id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public Integer getComments() {
        return comments;
    }

    public Integer getReadComments() {
        return readComments;
    }

    public Integer getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getViewUrl() {
        return viewUrl;
    }
}
