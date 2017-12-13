package by.laligulbani.vk.entity.group;


import com.google.gson.annotations.SerializedName;

import by.laligulbani.vk.entity.base.BaseObject;
import by.laligulbani.vk.entity.base.BoolInt;
import by.laligulbani.vk.entity.base.Country;
import by.laligulbani.vk.entity.base.Place;

public class GroupFull extends Group {

    /**
     * Information whether community is in faves
     */
    @SerializedName("is_favorite")
    private BoolInt isFavorite;

    /**
     * Information whether current user hide posts from community in newsfeed
     */
    @SerializedName("is_hidden_from_feed")
    private BoolInt isHiddenFromFeed;

    /**
     * Information whether current user is subscribed
     */
    @SerializedName("is_subscribed")
    private BoolInt isSubscribed;

    @SerializedName("city")
    private BaseObject city;

    @SerializedName("country")
    private Country country;

    /**
     * Information whether community is verified
     */
    @SerializedName("verified")
    private BoolInt verified;

    /**
     * Community description
     */
    @SerializedName("description")
    private String description;

    /**
     * Community's main wiki page title
     */
    @SerializedName("wiki_page")
    private String wikiPage;

    /**
     * Information whether current user can post on community's wall
     */
    @SerializedName("can_post")
    private BoolInt canPost;

    /**
     * Information whether current user can see all posts on community's wall
     */
    @SerializedName("can_see_all_posts")
    private BoolInt canSeeAllPosts;

    /**
     * Type of group, start date of event or category of public page
     */
    @SerializedName("activity")
    private String activity;

    /**
     * Fixed post ID
     */
    @SerializedName("fixed_post")
    private Integer fixedPost;

    /**
     * Information whether current user can create topic
     */
    @SerializedName("can_create_topic")
    private BoolInt canCreateTopic;

    /**
     * Information whether current user can upload doc
     */
    @SerializedName("can_upload_doc")
    private BoolInt canUploadDoc;

    /**
     * Information whether current user can upload video
     */
    @SerializedName("can_upload_video")
    private BoolInt canUploadVideo;

    /**
     * Community status
     */
    @SerializedName("status")
    private String status;

    /**
     * Community's website
     */
    @SerializedName("site")
    private String site;

    /**
     * Information whether current user can send a message to community
     */
    @SerializedName("can_message")
    private BoolInt canMessage;

    /**
     * Information whether current user allow to community send a message
     */
    @SerializedName("is_messages_allowed")
    private BoolInt isMessagesAllowed;

    /**
     * Label for star date
     */
    @SerializedName("public_date_label")
    private String publicDateLabel;

    /**
     * Start date of event in Unixtime
     */
    @SerializedName("start_date")
    private Integer startDate;

    /**
     * Finish date of event in Unixtime
     */
    @SerializedName("finish_date")
    private Integer finishDate;

    /**
     * Information whether community has photo
     */
    @SerializedName("has_photo")
    private BoolInt hasPhoto;


    /**
     * Community's place
     */
    @SerializedName("place")
    private Place place;

    public boolean isFavorite() {
        return isFavorite == BoolInt.YES;
    }

    public boolean isHiddenFromFeed() {
        return isHiddenFromFeed == BoolInt.YES;
    }

    public boolean isSubscribed() {
        return isSubscribed == BoolInt.YES;
    }

    public BaseObject getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public boolean isVerified() {
        return verified == BoolInt.YES;
    }

    public String getDescription() {
        return description;
    }

    public String getWikiPage() {
        return wikiPage;
    }

    public boolean canPost() {
        return canPost == BoolInt.YES;
    }

    public boolean canSeeAllPosts() {
        return canSeeAllPosts == BoolInt.YES;
    }

    public String getActivity() {
        return activity;
    }

    public Integer getFixedPost() {
        return fixedPost;
    }

    public boolean canCreateTopic() {
        return canCreateTopic == BoolInt.YES;
    }

    public boolean canUploadDoc() {
        return canUploadDoc == BoolInt.YES;
    }

    public boolean canUploadVideo() {
        return canUploadVideo == BoolInt.YES;
    }

    public String getStatus() {
        return status;
    }

    public String getSite() {
        return site;
    }

    public boolean canMessage() {
        return canMessage == BoolInt.YES;
    }

    public boolean isMessagesAllowed() {
        return isMessagesAllowed == BoolInt.YES;
    }

    public String getPublicDateLabel() {
        return publicDateLabel;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public Integer getFinishDate() {
        return finishDate;
    }

    public boolean hasPhoto() {
        return hasPhoto == BoolInt.YES;
    }

    public Place getPlace() {
        return place;
    }

}
