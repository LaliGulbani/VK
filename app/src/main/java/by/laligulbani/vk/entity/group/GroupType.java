package by.laligulbani.vk.entity.group;


import com.google.gson.annotations.SerializedName;

public enum GroupType {
    @SerializedName("group")
    GROUP("group"),

    @SerializedName("page")
    PAGE("page"),

    @SerializedName("event")
    EVENT("event");

    private final String value;

    GroupType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
