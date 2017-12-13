package by.laligulbani.vk.entity.base;


import com.google.gson.annotations.SerializedName;

public class RepostsInfo {
    /**
     * Reposts number
     */
    @SerializedName("count")
    private Integer count;

    /**
     * Information whether current user has reposted the post
     */
    @SerializedName("user_reposted")
    private Integer userReposted;

    public Integer getCount() {
        return count;
    }

    public Integer getUserReposted() {
        return userReposted;
    }

}
