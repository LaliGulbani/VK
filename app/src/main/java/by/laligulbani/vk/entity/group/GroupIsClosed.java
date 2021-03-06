package by.laligulbani.vk.entity.group;


import com.google.gson.annotations.SerializedName;

public enum GroupIsClosed {
    @SerializedName("0")
    OPEN(0),

    @SerializedName("1")
    CLOSED(1),

    @SerializedName("2")
    PRIVATE(2);

    private final Integer value;

    GroupIsClosed(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
