package by.laligulbani.vk.model.facade.dto;

import android.graphics.Bitmap;

public class DialogDto {

    private final String from;
    private final String date;
    private final String body;
    private final Bitmap image;

    public DialogDto(final String from,
                     final String date,
                     final String body,
                     final Bitmap image) {
        this.from = from;
        this.date = date;
        this.body = body;
        this.image = image;
    }

    public String getFrom() {
        return from;
    }

    public String getDate() {
        return date;
    }

    public String getBody() {
        return body;
    }

    public Bitmap getImage() {
        return image;
    }
}
