package by.laligulbani.vk.entity.base;


import com.google.gson.annotations.SerializedName;

public class Place {
    /**
     * Place ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Place title
     */
    @SerializedName("title")
    private String title;

    /**
     * Place latitude
     */
    @SerializedName("latitude")
    private Float latitude;

    /**
     * Place longitude
     */
    @SerializedName("longitude")
    private Float longitude;

    /**
     * Date of the place creation in Unixtime
     */
    @SerializedName("created")
    private Integer created;

    /**
     * URL of the place's icon
     */
    @SerializedName("icon")
    private String icon;

    /**
     * Checkins number
     */
    @SerializedName("checkins")
    private Integer checkins;

    /**
     * Place type
     */
    @SerializedName("type")
    private String type;

    /**
     * Country name
     */
    @SerializedName("country")
    private String country;

    /**
     * City name
     */
    @SerializedName("city")
    private String city;

    /**
     * Place address
     */
    @SerializedName("address")
    private String address;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Float getLatitude() {
        return latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Integer getCreated() {
        return created;
    }

    public String getIcon() {
        return icon;
    }

    public Integer getCheckins() {
        return checkins;
    }

    public String getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
