package by.laligulbani.vk.entity.wall;


import com.google.gson.annotations.SerializedName;

public class AppPost {
    /**
     * Application ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Application name
     */
    @SerializedName("name")
    private String name;

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

    public String getName() {
        return name;
    }

    public String getPhoto130() {
        return photo130;
    }

    public String getPhoto604() {
        return photo604;
    }
}
