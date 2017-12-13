package by.laligulbani.vk.entity.base;


import com.google.gson.annotations.SerializedName;

public class Geo {
    /**
     * Place type
     */
    @SerializedName("type")
    private String type;

    /**
     * String with coordinates
     */
    @SerializedName("coordinates")
    private String coordinates;

    @SerializedName("place")
    private Place place;

    /**
     * Information whether a map is showed
     */
    @SerializedName("showmap")
    private Integer showmap;

    public String getType() {
        return type;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public Place getPlace() {
        return place;
    }

    public Integer getShowmap() {
        return showmap;
    }
}
