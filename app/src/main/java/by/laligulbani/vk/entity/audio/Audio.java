package by.laligulbani.vk.entity.audio;


import com.google.gson.annotations.SerializedName;

public class Audio {
    /**
     * Audio ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Audio owner's ID
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Artist name
     */
    @SerializedName("artist")
    private String artist;

    /**
     * Title
     */
    @SerializedName("title")
    private String title;

    /**
     * URL of mp3 file
     */
    @SerializedName("url")
    private String url;

    /**
     * Access key for the audio
     */
    @SerializedName("access_key")
    private String accessKey;

    public Integer getId() {
        return id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getAccessKey() {
        return accessKey;
    }
}
