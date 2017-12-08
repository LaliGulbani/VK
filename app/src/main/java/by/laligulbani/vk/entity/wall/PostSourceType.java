package by.laligulbani.vk.entity.wall;

import com.google.gson.annotations.SerializedName;

public enum PostSourceType {
    @SerializedName("vk")
    VK("vk"),

    @SerializedName("widget")
    WIDGET("widget"),

    @SerializedName("api")
    API("api"),

    @SerializedName("rss")
    RSS("rss"),

    @SerializedName("sms")
    SMS("sms");

    private final String value;

    PostSourceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
