package by.laligulbani.vk.entity.audio;

import com.google.gson.annotations.SerializedName;

import by.laligulbani.vk.entity.base.BoolInt;

/**
 * AudioFull object
 */
public class AudioFull extends Audio {
    /**
     * Duration in seconds
     */
    @SerializedName("duration")
    private Integer duration;

    /**
     * Date when uploaded
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Album ID
     */
    @SerializedName("album_id")
    private Integer albumId;

    /**
     * Lyrics ID
     */
    @SerializedName("lyrics_id")
    private Integer lyricsId;

    /**
     * Genre ID
     */
    @SerializedName("genre_id")
    private Integer genreId;

    /**
     * Information whether the audio is hidden from search
     */
    @SerializedName("no_search")
    private BoolInt noSearch;

    public Integer getDuration() {
        return duration;
    }

    public Integer getDate() {
        return date;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public Integer getLyricsId() {
        return lyricsId;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public boolean isNoSearch() {
        return noSearch == BoolInt.YES;
    }

}
