package by.laligulbani.vk.entity.docs;


import com.google.gson.annotations.SerializedName;

public class DocPreviewVideo {
    /**
     * Video url
     */
    @SerializedName("src")
    private String src;

    /**
     * Video's width in pixels
     */
    @SerializedName("width")
    private Integer width;

    /**
     * Video's height in pixels
     */
    @SerializedName("height")
    private Integer height;

    /**
     * Video file size in bites
     */
    @SerializedName("filesize")
    private Integer filesize;

    public String getSrc() {
        return src;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getFilesize() {
        return filesize;
    }
}
