package by.laligulbani.vk.entity.user_profile;


import com.google.gson.annotations.SerializedName;

public class LastSeen {
    @SerializedName("time")
    public long time_last_seen;
    @SerializedName("platform ")
    public long platform;


    public long getTime_last_seen() {
        return time_last_seen;
    }

    public void setTime_last_seen(long time_last_seen) {
        this.time_last_seen = time_last_seen;
    }

    public long getPlatform() {
        return platform;
    }

    public void setPlatform(long platform) {
        this.platform = platform;
    }

}
