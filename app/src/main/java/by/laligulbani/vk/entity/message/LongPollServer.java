package by.laligulbani.vk.entity.message;

import com.google.gson.annotations.SerializedName;

public class LongPollServer {

    @SerializedName("server")
    private String server;

    @SerializedName("key")
    private String key;

    @SerializedName("ts")
    private String ts;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

}
