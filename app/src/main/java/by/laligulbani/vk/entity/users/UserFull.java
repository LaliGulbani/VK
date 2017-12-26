package by.laligulbani.vk.entity.users;


import com.google.gson.annotations.SerializedName;

import by.laligulbani.vk.entity.base.BaseObject;
import by.laligulbani.vk.entity.base.BoolInt;

public class UserFull extends User {


    /**
     * MyUser's date of birth
     */
    @SerializedName("bdate")
    private String bdate;

    @SerializedName("city")
    private BaseObject city;

    /**
     * URL of square photo of the user with 200 pixels in width
     */
    @SerializedName("photo_200")
    private String photo200;

    /**
     * URL of square photo of the user with maximum width
     */
    @SerializedName("photo_max")
    private String photoMax;

    /**
     * URL of user's photo with 200 pixels in width
     */
    @SerializedName("photo_200_orig")
    private String photo200Orig;

    /**
     * URL of user's photo with 400 pixels in width
     */
    @SerializedName("photo_400_orig")
    private String photo400Orig;

    /**
     * URL of user's photo of maximum size
     */
    @SerializedName("photo_max_orig")
    private String photoMaxOrig;

    /**
     * ID of the user's main photo
     */
    @SerializedName("photo_id")
    private String photoId;

    /**
     * Information whether the user has main photo
     */
    @SerializedName("has_photo")
    private BoolInt hasPhoto;


    /**
     * Information whether the user is a friend of current user
     */
    @SerializedName("is_friend")
    private BoolInt isFriend;

    /**
     * Friend status for current user
     */
    @SerializedName("friend_status")
    private Integer friendStatus;

    /**
     * Information whether current user can post on the user's wall
     */
    @SerializedName("can_post")
    private BoolInt canPost;

    /**
     * Information whether current user can see other users' audio on the wall
     */
    @SerializedName("can_see_all_posts")
    private BoolInt canSeeAllPosts;

    /**
     * Information whether current user can see the user's audio
     */
    @SerializedName("can_see_audio")
    private BoolInt canSeeAudio;

    /**
     * Information whether current user can write private message
     */
    @SerializedName("can_write_private_message")
    private BoolInt canWritePrivateMessage;

    /**
     * Information whether current user can send a friend request
     */
    @SerializedName("can_send_friend_request")
    private BoolInt canSendFriendRequest;

    /**
     * Information whether current user can see
     */
    @SerializedName("mobile_phone")
    private String mobilePhone;

    /**
     * MyUser's status
     */
    @SerializedName("status")
    private String status;


    @SerializedName("last_seen")
    private LastSeen lastSeen;

    /**
     * Information whether the user is verified
     */
    @SerializedName("verified")
    private BoolInt verified;

    /**
     * Number of user's followers
     */
    @SerializedName("followers_count")
    private Integer followersCount;

    /**
     * Information whether current user is in the requested user's blacklist.
     */
    @SerializedName("blacklisted")
    private BoolInt blacklisted;

    /**
     * Information whether the requested user is in current user's blacklist
     */
    @SerializedName("blacklisted_by_me")
    private BoolInt blacklistedByMe;

    /**
     * Information whether the requested user is in faves of current user
     */
    @SerializedName("is_favorite")
    private BoolInt isFavorite;

    /**
     * Information whether the requested user is hidden from current user's newsfeed
     */
    @SerializedName("is_hidden_from_feed")
    private BoolInt isHiddenFromFeed;

    /**
     * Number of common friends with current user
     */
    @SerializedName("common_count")
    private Integer commonCount;


    /**
     * MyUser hometown
     */
    @SerializedName("home_town")
    private String homeTown;


    /**
     * MyUser's interests
     */
    @SerializedName("interests")
    private String interests;

    /**
     * MyUser's favorite music
     */
    @SerializedName("music")
    private String music;

    /**
     * MyUser's activities
     */
    @SerializedName("activities")
    private String activities;

    /**
     * Favorite quotes
     */
    @SerializedName("quotes")
    private String quotes;


    public String getBdate() {
        return bdate;
    }

    public BaseObject getCity() {
        return city;
    }

    public String getPhoto200() {
        return photo200;
    }

    public String getPhotoMax() {
        return photoMax;
    }

    public String getPhoto200Orig() {
        return photo200Orig;
    }

    public String getPhoto400Orig() {
        return photo400Orig;
    }

    public String getPhotoMaxOrig() {
        return photoMaxOrig;
    }

    public String getPhotoId() {
        return photoId;
    }

    public boolean hasPhoto() {
        return hasPhoto == BoolInt.YES;
    }

    public boolean isFriend() {
        return isFriend == BoolInt.YES;
    }

    public Integer getFriendStatus() {
        return friendStatus;
    }

    public boolean canPost() {
        return canPost == BoolInt.YES;
    }

    public boolean canSeeAllPosts() {
        return canSeeAllPosts == BoolInt.YES;
    }

    public boolean canSeeAudio() {
        return canSeeAudio == BoolInt.YES;
    }

    public boolean canWritePrivateMessage() {
        return canWritePrivateMessage == BoolInt.YES;
    }

    public boolean canSendFriendRequest() {
        return canSendFriendRequest == BoolInt.YES;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getStatus() {
        return status;
    }

    public LastSeen getLastSeen() {
        return lastSeen;
    }

    public boolean isVerified() {
        return verified == BoolInt.YES;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public boolean isBlacklisted() {
        return blacklisted == BoolInt.YES;
    }

    public boolean isBlacklistedByMe() {
        return blacklistedByMe == BoolInt.YES;
    }

    public boolean isFavorite() {
        return isFavorite == BoolInt.YES;
    }

    public boolean isHiddenFromFeed() {
        return isHiddenFromFeed == BoolInt.YES;
    }

    public Integer getCommonCount() {
        return commonCount;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public String getInterests() {
        return interests;
    }

    public String getMusic() {
        return music;
    }

    public String getActivities() {
        return activities;
    }

    public String getQuotes() {
        return quotes;
    }
}
