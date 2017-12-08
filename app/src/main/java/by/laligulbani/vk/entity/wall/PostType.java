package by.laligulbani.vk.entity.wall;


import com.google.gson.annotations.SerializedName;

public enum PostType {
    @SerializedName("post")
    POST("post"),

    @SerializedName("copy")
    COPY("copy"),

    @SerializedName("reply")
    REPLY("reply"),

    @SerializedName("postpone")
    POSTPONE("postpone"),

    @SerializedName("suggest")
    SUGGEST("suggest");

    private final String value;

    PostType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
