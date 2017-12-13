package by.laligulbani.vk.entity.wall;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.laligulbani.vk.entity.audio.AudioFull;
import by.laligulbani.vk.entity.docs.Doc;
import by.laligulbani.vk.entity.photo.Photo;
import by.laligulbani.vk.entity.video.Video;

class WallpostAttachment {
    @SerializedName("photo")
    private Photo photo;

    @SerializedName("posted_photo")
    private PostedPhoto postedPhoto;

    @SerializedName("audio")
    private AudioFull audio;

    @SerializedName("video")
    private Video video;

    @SerializedName("Doc")
    private Doc doc;

   // @SerializedName("link")
    //private Link link;



    @SerializedName("note")
    private AttachedNote note;

    @SerializedName("app")
    private AppPost app;

    @SerializedName("photos_list")
    private List<String> photosList;

    /**
     * Attachment type
     */
    @SerializedName("type")
    private WallpostAttachmentType type;

    public Photo getPhoto() {
        return photo;
    }

    public PostedPhoto getPostedPhoto() {
        return postedPhoto;
    }

    public AudioFull getAudio() {
        return audio;
    }

    public Video getVideo() {
        return video;
    }

    public Doc getDoc() {
        return doc;
    }

    public AttachedNote getNote() {
        return note;
    }

    public AppPost getApp() {
        return app;
    }

    public List<String> getPhotosList() {
        return photosList;
    }

    public WallpostAttachmentType getType() {
        return type;
    }

}
