package by.laligulbani.vk.entity.users;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyUser {

    @SerializedName("id") // идентификатор пользователя.
    private long id;
    @SerializedName("first_name") // имя
    private String  first_name;
    @SerializedName("last_name") //фамилия
    private long last_name;
    @SerializedName("bdate") //дата др
    private String birthday_date;
    @SerializedName("city") // информация о городе, указанном на странице пользователя в разделе «Контакты».
    private List<City> city;
    @SerializedName("home_town") // название родного города.
    private String home_town;
    @SerializedName("can_write_private_message")  //информация о том, может ли текущий пользователь отправить личное сообщение.
    private long can_write_private_message; //integer, [0,1]; 1 — может; 0 — не может.
    @SerializedName("common_count") // количество общих друзей с текущим пользователем.
    private long common_count;
    @SerializedName("followers_count") // количество подписчиков пользователя.
    private long followers_count;
    @SerializedName("counters") // количество различных объектов у пользователя
    private List<Counters> counters;
    @SerializedName("is_friend") // информация о том, является ли пользователь другом текущего пользователя
    private long is_friend; //1 — да; 0 — нет.
    @SerializedName("last_seen") // время последнего посещения. Объект, содержащий следующие поля:
    private List<LastSeen> last_seen;
    @SerializedName("online") // информация о том, находится ли пользователь сейчас на сайте
    private long online; //integer, [0,1]
    @SerializedName("photo_50") // url квадратной фотографии пользователя, имеющей ширину 50 пикселей
    private String photo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public long getLast_name() {
        return last_name;
    }

    public void setLast_name(long last_name) {
        this.last_name = last_name;
    }

    public String getBirthday_date() {
        return birthday_date;
    }

    public void setBirthday_date(String birthday_date) {
        this.birthday_date = birthday_date;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

    public String getHome_town() {
        return home_town;
    }

    public void setHome_town(String home_town) {
        this.home_town = home_town;
    }

    public long getCan_write_private_message() {
        return can_write_private_message;
    }

    public void setCan_write_private_message(long can_write_private_message) {
        this.can_write_private_message = can_write_private_message;
    }

    public long getCommon_count() {
        return common_count;
    }

    public void setCommon_count(long common_count) {
        this.common_count = common_count;
    }

    public long getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(long followers_count) {
        this.followers_count = followers_count;
    }

    public List<Counters> getCounters() {
        return counters;
    }

    public void setCounters(List<Counters> counters) {
        this.counters = counters;
    }

    public long getIs_friend() {
        return is_friend;
    }

    public void setIs_friend(long is_friend) {
        this.is_friend = is_friend;
    }

    public List<LastSeen> getLast_seen() {
        return last_seen;
    }

    public void setLast_seen(List<LastSeen> last_seen) {
        this.last_seen = last_seen;
    }

    public long getOnline() {
        return online;
    }

    public void setOnline(long online) {
        this.online = online;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
