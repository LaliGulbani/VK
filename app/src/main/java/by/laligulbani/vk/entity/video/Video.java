package by.laligulbani.vk.entity.video;


import com.google.gson.annotations.SerializedName;

import by.laligulbani.vk.entity.base.BoolInt;

public class Video {
    /**
     * Video ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Video owner ID
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Video title
     */
    @SerializedName("title")
    private String title;

    /**
     * Video duration in seconds
     */
    @SerializedName("duration")
    private Integer duration;

    /**
     * Video description
     */
    @SerializedName("description")
    private String description;

    /**
     * Date when video has been uploaded in Unixtime
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Number of views
     */
    @SerializedName("views")
    private Integer views;

    /**
     * Number of comments
     */
    @SerializedName("comments")
    private Integer comments;

    /**
     * URL of the preview image with 130 px in width
     */
    @SerializedName("photo_130")
    private String photo130;

    /**
     * URL of the preview image with 320 px in width
     */
    @SerializedName("photo_320")
    private String photo320;

    /**
     * URL of the preview image with 800 px in width
     */
    @SerializedName("photo_800")
    private String photo800;

    /**
     * Video access key
     */
    @SerializedName("access_key")
    private String accessKey;

    /**
     * Date when the video has been added in Unixtime
     */
    @SerializedName("adding_date")
    private Integer addingDate;

    /**
     * URL of the page with a player that can be used to play the video in the browser.
     */
    @SerializedName("player")
    private String player;

    /**
     * Information whether current user can edit the video
     */
    @SerializedName("can_edit")
    private BoolInt canEdit;

    /**
     * Information whether current user can add the video
     */
    @SerializedName("can_add")
    private BoolInt canAdd;


    public Integer getId() {
        return id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDate() {
        return date;
    }

    public Integer getViews() {
        return views;
    }

    public Integer getComments() {
        return comments;
    }

    public String getPhoto130() {
        return photo130;
    }

    public String getPhoto320() {
        return photo320;
    }

    public String getPhoto800() {
        return photo800;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public Integer getAddingDate() {
        return addingDate;
    }

    public String getPlayer() {
        return player;
    }

    public boolean canEdit() {
        return canEdit == BoolInt.YES;
    }

    public boolean canAdd() {
        return canAdd == BoolInt.YES;
    }
}
