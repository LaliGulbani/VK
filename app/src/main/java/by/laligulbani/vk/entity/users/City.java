package by.laligulbani.vk.entity.users;


import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("id")
    public long id_city;
    @SerializedName("title")
    public String title_city;

    public long getId_city() {
        return id_city;
    }

    public void setId_city(long id_city) {
        this.id_city = id_city;
    }

    public String getTitle_city() {
        return title_city;
    }

    public void setTitle_city(String title_city) {
        this.title_city = title_city;
    }
}
