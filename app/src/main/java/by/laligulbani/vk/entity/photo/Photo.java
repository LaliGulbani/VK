package by.laligulbani.vk.entity.photo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photo {
    /**
     * Photo ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Album ID
     */
    @SerializedName("album_id")
    private Integer albumId;

    /**
     * Photo owner's ID
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * ID of the user who have uploaded the photo
     */
    @SerializedName("user_id")
    private Integer userId;

    @SerializedName("sizes")
    private List<PhotoSizes> sizes;

    /**
     * URL of image with 75 px width
     */
    @SerializedName("photo_75")
    private String photo75;

    /**
     * URL of image with 130 px width
     */
    @SerializedName("photo_130")
    private String photo130;

    /**
     * URL of image with 604 px width
     */
    @SerializedName("photo_604")
    private String photo604;

    /**
     * URL of image with 807 px width
     */
    @SerializedName("photo_807")
    private String photo807;

    /**
     * URL of image with 1280 px width
     */
    @SerializedName("photo_1280")
    private String photo1280;

    /**
     * URL of image with 2560 px width
     */
    @SerializedName("photo_2560")
    private String photo2560;

    /**
     * Post ID
     */
    @SerializedName("post_id")
    private Integer postId;

    /**
     * Original photo width
     */
    @SerializedName("width")
    private Integer width;

    /**
     * Original photo height
     */
    @SerializedName("height")
    private Integer height;

    /**
     * Photo caption
     */
    @SerializedName("text")
    private String text;

    /**
     * Date when uploaded
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Latitude
     */
    @SerializedName("lat")
    private Float lat;

    /**
     * Longitude
     */
    @SerializedName("long")
    private Float lng;

    /**
     * Access key for the photo
     */
    @SerializedName("access_key")
    private String accessKey;

    public Integer getId() {
        return id;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public List<PhotoSizes> getSizes() {
        return sizes;
    }

    public String getPhoto75() {
        return photo75;
    }

    public String getPhoto130() {
        return photo130;
    }

    public String getPhoto604() {
        return photo604;
    }

    public String getPhoto807() {
        return photo807;
    }

    public String getPhoto1280() {
        return photo1280;
    }

    public String getPhoto2560() {
        return photo2560;
    }

    public Integer getPostId() {
        return postId;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public String getText() {
        return text;
    }

    public Integer getDate() {
        return date;
    }

    public Float getLat() {
        return lat;
    }

    public Float getLng() {
        return lng;
    }

    public String getAccessKey() {
        return accessKey;
    }
}