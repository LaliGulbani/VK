package by.laligulbani.vk.entity.docs;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.laligulbani.vk.entity.photo.PhotoSizes;

public class DocPreviewPhoto {

    @SerializedName("sizes")
    private List<PhotoSizes> sizes;

    public List<PhotoSizes> getSizes() {
        return sizes;
    }
}
