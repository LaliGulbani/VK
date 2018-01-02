package by.laligulbani.vk.model.parser.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import by.laligulbani.vk.entity.messages.DialogResponse;


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
                case "count":
                    response.setCount(in.nextString());
                    break;
                case "items":
                    response.setMessages(in.);
                    break;
            }
        }
        in.endObject();

        return response;
    }
}
