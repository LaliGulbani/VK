package by.laligulbani.vk.entity.newsfeed;


import com.google.gson.annotations.SerializedName;

public class NewsfeedItem {
    /**
     * Item type
     */
    @SerializedName("type")
    private NewsfeedItemType type;

    /**
     * Item source ID
     */
    @SerializedName("source_id")
    private Integer sourceId;

    /**
     * Date when item has been added in Unixtime
     */
    @SerializedName("date")
    private Integer date;

    public NewsfeedItemType getType() {
        return type;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public Integer getDate() {
        return date;
    }

}
