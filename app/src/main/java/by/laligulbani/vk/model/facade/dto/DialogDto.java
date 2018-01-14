package by.laligulbani.vk.model.facade.dto;

public class DialogDto {

    private final String id;
    private final String from;
    private final String date;
    private final String body;
    private final String image;

    public DialogDto(final String id,
                     final String from,
                     final String date,
                     final String body,
                     final String image) {
        this.id = id;
        this.from = from;
        this.date = date;
        this.body = body;
        this.image = image;
    }

    public String getId() {
        return id;
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

    public String getImage() {
        return image;
    }
}
