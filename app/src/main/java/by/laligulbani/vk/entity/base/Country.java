package by.laligulbani.vk.entity.base;

import com.google.gson.annotations.SerializedName;

public class Country {
    /**
     * Country ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Country title
     */
    @SerializedName("title")
    private String title;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
