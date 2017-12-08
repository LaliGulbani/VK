package by.laligulbani.vk.entity.wall;


import com.google.gson.annotations.SerializedName;

public class PostedPhoto {
    /**
     * Photo ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Photo owner's ID
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * URL of the preview image with 130 px in width
     */
    @SerializedName("photo_130")
    private String photo130;

    /**
     * URL of the preview image with 604 px in width
     */
    @SerializedName("photo_604")
    private String photo604;

    public Integer getId() {
        return id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public String getPhoto130() {
        return photo130;
    }

    public String getPhoto604() {
        return photo604;
    }


}
