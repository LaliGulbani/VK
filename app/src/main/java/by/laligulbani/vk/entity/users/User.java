package by.laligulbani.vk.entity.users;

import com.google.gson.annotations.SerializedName;

import by.laligulbani.vk.entity.base.BoolInt;
import by.laligulbani.vk.entity.base.Sex;

public class User extends UserMin {
    /**
     * User sex
     */
    @SerializedName("sex")
    private Sex sex;

    /**
     * Domain name of the user's page
     */
    @SerializedName("screen_name")
    private String screenName;

    /**
     * URL of square photo of the user with 50 pixels in width
     */
    @SerializedName("photo_50")
    private String photo50;

    /**
     * URL of square photo of the user with 100 pixels in width
     */
    @SerializedName("photo_100")
    private String photo100;

    /**
     * Information whether the user is online
     */
    @SerializedName("online")
    private BoolInt online;

    /**
     * Information whether the user is online in mobile site or application
     */
    @SerializedName("online_mobile")
    private BoolInt onlineMobile;

    /**
     * Application ID
     */
    @SerializedName("online_app")
    private Integer onlineApp;

    public Sex getSex() {
        return sex;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getPhoto50() {
        return photo50;
    }

    public String getPhoto100() {
        return photo100;
    }

    public boolean isOnline() {
        return online == BoolInt.YES;
    }

    public boolean isOnlineMobile() {
        return onlineMobile == BoolInt.YES;
    }

    public Integer getOnlineApp() {
        return onlineApp;
    }

}
