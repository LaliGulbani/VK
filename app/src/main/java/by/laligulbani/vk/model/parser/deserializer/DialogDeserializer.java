package by.laligulbani.vk.model.parser.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import by.laligulbani.vk.model.parser.wrappers.DialogResponse;

public class DialogDeserializer implements JsonDeserializer<DialogResponse> {

    private final Gson gson;

    public DialogDeserializer(final Gson gson) {
        this.gson = gson;
    }

    @Override
    public DialogResponse deserialize(final JsonElement jsonElement,
                                      final Type typeOfT,
                                      final JsonDeserializationContext context) throws JsonParseException {

        final JsonObject source = jsonElement.getAsJsonObject();

        final JsonArray array = source.getAsJsonArray("response");

        final JsonArray items = new JsonArray();
        for (int i = 1; i < array.size(); i++) {
            items.add(array.get(i));
        }

        final JsonObject response = new JsonObject();
        response.add("count", array.get(0));
        response.add("items", items);

        return gson.fromJson(response.toString(), DialogResponse.class);
    }
}
