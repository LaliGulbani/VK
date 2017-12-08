package by.laligulbani.vk.entity.group;


import com.google.gson.annotations.SerializedName;

import by.laligulbani.vk.entity.base.BoolInt;

public class Group {
    /**
     * Community ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Community name
     */
    @SerializedName("name")
    private String name;

    /**
     * Returns if a group is deleted or blocked
     */
    @SerializedName("deactivated")
    private String deactivated;

    /**
     * Domain of the community page
     */
    @SerializedName("screen_name")
    private String screenName;

    /**
     * Information whether community is closed
     */
    @SerializedName("is_closed")
    private GroupIsClosed isClosed;

    /**
     * Community type
     */
    @SerializedName("type")
    private GroupType type;

    /**
     * Information whether current user is administrator
     */
    @SerializedName("is_admin")
    private BoolInt isAdmin;

    /**
     * Information whether current user is member
     */
    @SerializedName("is_member")
    private BoolInt isMember;

    /**
     * URL of square photo of the community with 50 pixels in width
     */
    @SerializedName("photo_50")
    private String photo50;

    /**
     * URL of square photo of the community with 100 pixels in width
     */
    @SerializedName("photo_100")
    private String photo100;

    /**
     * URL of square photo of the community with 200 pixels in width
     */
    @SerializedName("photo_200")
    private String photo200;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDeactivated() {
        return deactivated;
    }

    public String getScreenName() {
        return screenName;
    }

    public GroupIsClosed getIsClosed() {
        return isClosed;
    }

    public GroupType getType() {
        return type;
    }

    public boolean isAdmin() {
        return isAdmin == BoolInt.YES;
    }

    public boolean isMember() {
        return isMember == BoolInt.YES;
    }

    public String getPhoto50() {
        return photo50;
    }

    public String getPhoto100() {
        return photo100;
    }

    public String getPhoto200() {
        return photo200;
    }

}
