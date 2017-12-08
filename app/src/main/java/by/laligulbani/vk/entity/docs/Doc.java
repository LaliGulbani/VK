package by.laligulbani.vk.entity.docs;


import com.google.gson.annotations.SerializedName;

public class Doc {
    /**
     * Document ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Document owner ID
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Document title
     */
    @SerializedName("title")
    private String title;

    /**
     * File size in bites
     */
    @SerializedName("size")
    private Integer size;

    /**
     * File extension
     */
    @SerializedName("ext")
    private String ext;

    /**
     * File URL
     */
    @SerializedName("url")
    private String url;

    /**
     * Date when file has been uploaded in Unixtime
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Document type
     */
    @SerializedName("type")
    private Integer type;

    @SerializedName("preview")
    private DocPreview preview;

    /**
     * Access key for the document
     */
    @SerializedName("access_key")
    private String accessKey;

    public Integer getId() {
        return id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getSize() {
        return size;
    }

    public String getExt() {
        return ext;
    }

    public String getUrl() {
        return url;
    }

    public Integer getDate() {
        return date;
    }

    public Integer getType() {
        return type;
    }

    public DocPreview getPreview() {
        return preview;
    }

    public String getAccessKey() {
        return accessKey;
    }

}
