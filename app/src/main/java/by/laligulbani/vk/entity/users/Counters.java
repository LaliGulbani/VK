package by.laligulbani.vk.entity.users;


import com.google.gson.annotations.SerializedName;

public class Counters {

    @SerializedName("item_friends")
    public long friends_count;
    @SerializedName("followers ")
    public long followers_count;
    @SerializedName("photos")
    public long photos_count;
    @SerializedName(" videos")
    public long videos_count;

    public long getFriends_count() {
        return friends_count;
    }

    public void setFriends_count(long friends_count) {
        this.friends_count = friends_count;
    }

    public long getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(long followers_count) {
        this.followers_count = followers_count;
    }

    public long getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(long photos_count) {
        this.photos_count = photos_count;
    }

    public long getVideos_count() {
        return videos_count;
    }

    public void setVideos_count(long videos_count) {
        this.videos_count = videos_count;
    }


}
