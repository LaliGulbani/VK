package by.laligulbani.vk.entity.photo;


import com.google.gson.annotations.SerializedName;

public class PhotoSizes {
         /* URL of the image
     */
    @SerializedName("src")
    private String src;

    /**
     * Width in px
     */
    @SerializedName("width")
    private Integer width;

    /**
     * Height in px
     */
    @SerializedName("height")
    private Integer height;

    /**
     * Size type
     */
    @SerializedName("type")
    private PhotoSizesType type;

    public String getSrc() {
        return src;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public PhotoSizesType getType() {
        return type;
    }
}
