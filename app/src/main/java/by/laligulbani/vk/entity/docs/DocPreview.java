package by.laligulbani.vk.entity.docs;

import com.google.gson.annotations.SerializedName;

public class DocPreview {
    @SerializedName("photo")
    private DocPreviewPhoto photo;

    @SerializedName("video")
    private DocPreviewVideo video;

    public DocPreviewPhoto getPhoto() {
        return photo;
    }

    public DocPreviewVideo getVideo() {
        return video;
    }
}
