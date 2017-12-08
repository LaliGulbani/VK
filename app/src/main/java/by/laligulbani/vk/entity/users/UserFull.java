package by.laligulbani.vk.entity.users;


import com.google.gson.annotations.SerializedName;

import by.laligulbani.vk.entity.base.BaseObject;
import by.laligulbani.vk.entity.base.BoolInt;

public class UserFull extends User {
    /**
     * MyUser nickname
     */
    @SerializedName("nickname")
    private String nickname;

    /**
     * MyUser maiden name
     */
    @SerializedName("maiden_name")
    private String maidenName;

    /**
     * Domain name of the user's page
     */
    @SerializedName("domain")
    private String domain;

    /**
     * MyUser's date of birth
     */
    @SerializedName("bdate")
    private String bdate;

    @SerializedName("city")
    private BaseObject city;


    /**
     * MyUser's timezone
     */
    @SerializedName("timezone")
    private Integer timezone;

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
     * Information whether the user specified his phone number
     */
    @SerializedName("has_mobile")
    private BoolInt hasMobile;

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
     * Information whether current user can comment wall posts
     */
    @SerializedName("wall_comments")
    private BoolInt wallComments;

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
     * MyUser's mobile phone number
     */
    @SerializedName("home_phone")
    private String homePhone;

    /**
     * MyUser's Skype nickname
     */
    @SerializedName("skype")
    private String skype;

    /**
     * MyUser's Facebook account
     */
    @SerializedName("facebook")
    private String facebook;

    /**
     * MyUser's Facebook name
     */
    @SerializedName("facebook_name")
    private String facebookName;

    /**
     * MyUser's Twitter account
     */
    @SerializedName("twitter")
    private String twitter;

    /**
     * MyUser's Livejournal account
     */
    @SerializedName("livejournal")
    private String livejournal;

    /**
     * MyUser's Instagram account
     */
    @SerializedName("instagram")
    private String instagram;

    /**
     * MyUser's website
     */
    @SerializedName("site")
    private String site;


    /**
     * MyUser's status
     */
    @SerializedName("status")
    private String status;

    /**
     * MyUser's status
     */
    @SerializedName("activity")
    private String activity;

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
     * University ID
     */
    @SerializedName("university")
    private Integer university;

    /**
     * University name
     */
    @SerializedName("university_name")
    private String universityName;

    /**
     * Faculty ID
     */
    @SerializedName("faculty")
    private Integer faculty;

    /**
     * Faculty name
     */
    @SerializedName("faculty_name")
    private String facultyName;

    /**
     * Graduation year
     */
    @SerializedName("graduation")
    private Integer graduation;

    /**
     * Education form
     */
    @SerializedName("education_form")
    private String educationForm;

    /**
     * MyUser's education status
     */
    @SerializedName("education_status")
    private String educationStatus;

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
     * MyUser's favorite movies
     */
    @SerializedName("movies")
    private String movies;

    /**
     * MyUser's favorite tv shows
     */
    @SerializedName("tv")
    private String tv;

    /**
     * MyUser's favorite books
     */
    @SerializedName("books")
    private String books;

    /**
     * MyUser's favorite games
     */
    @SerializedName("games")
    private String games;


    /**
     * Favorite quotes
     */
    @SerializedName("quotes")
    private String quotes;

    public String getNickname() {
        return nickname;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public String getDomain() {
        return domain;
    }

    public String getBdate() {
        return bdate;
    }

    public BaseObject getCity() {
        return city;
    }

    public Integer getTimezone() {
        return timezone;
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

    public boolean hasMobile() {
        return hasMobile == BoolInt.YES;
    }

    public boolean isFriend() {
        return isFriend == BoolInt.YES;
    }

    public Integer getFriendStatus() {
        return friendStatus;
    }

    public boolean isWallComments() {
        return wallComments == BoolInt.YES;
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

    public String getHomePhone() {
        return homePhone;
    }

    public String getSkype() {
        return skype;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getFacebookName() {
        return facebookName;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getLivejournal() {
        return livejournal;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getSite() {
        return site;
    }

    public String getStatus() {
        return status;
    }

    public String getActivity() {
        return activity;
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

    public Integer getUniversity() {
        return university;
    }

    public String getUniversityName() {
        return universityName;
    }

    public Integer getFaculty() {
        return faculty;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public Integer getGraduation() {
        return graduation;
    }

    public String getEducationForm() {
        return educationForm;
    }

    public String getEducationStatus() {
        return educationStatus;
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

    public String getMovies() {
        return movies;
    }

    public String getTv() {
        return tv;
    }

    public String getBooks() {
        return books;
    }

    public String getGames() {
        return games;
    }

    public String getQuotes() {
        return quotes;
    }
}
