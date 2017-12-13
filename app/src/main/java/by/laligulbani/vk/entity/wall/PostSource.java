package by.laligulbani.vk.entity.wall;

import com.google.gson.annotations.SerializedName;



public class PostSource {
    /**
     * Type of post source
     */
    @SerializedName("type")
    private PostSourceType type;

    /**
     * Platform name
     */
    @SerializedName("platform")
    private String platform;

    /**
     * Additional data
     */
    @SerializedName("data")
    private String data;

    /**
     * URL to an external site used to publish the post
     */
    @SerializedName("url")
    private String url;

    public PostSourceType getType() {
        return type;
    }

    public String getPlatform() {
        return platform;
    }

    public String getData() {
        return data;
    }

    public String getUrl() {
        return url;
    }
}
