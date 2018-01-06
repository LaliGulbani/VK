package by.laligulbani.vk.model.parser.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.laligulbani.vk.entity.dialog.Dialog;
import by.laligulbani.vk.entity.dialog.DialogResponse;

public class DialogTypeAdapter extends TypeAdapter {

    @Override
    public void write(JsonWriter out, Object value) throws IOException {
    }

    @Override
    public Object read(JsonReader in) throws IOException {

        final DialogResponse response = new DialogResponse();

        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "response": {

                    final List<Dialog> dialogs = new ArrayList<>();
                    response.setMessages(dialogs);


                    if (in.peek().equals(JsonToken.BEGIN_ARRAY)) {
                        in.beginArray();
                    }

                    final Dialog dialog = new Dialog();

                    while (in.hasNext()) {
                        switch (in.nextName()) {
                            case "photo_50": {
                                dialog.setImage(in.nextString());
                            }
                            case "uid": {
                                dialog.setId(in.nextString());
                            }
                            break;
                            case "body": {
                                dialog.setBody(in.nextString());
                            }
                            break;
                            case "title": {
                                dialog.setTitle(in.nextString());
                            }
                            case "date": {
                                dialog.setDate(in.nextString());
                            }
                            break;
                            default: {
                                in.skipValue();
                            }
                            break;
                        }
                    }
                    dialogs.add(dialog);
                }
                break;
                default: {
                    in.skipValue();
                }
                break;
            }
        }
        in.endObject();

        return response;
    }
}
