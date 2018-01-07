package by.laligulbani.vk.model.parser.typeadapter;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import by.laligulbani.vk.model.parser.wrappers.UserFullResponse;

public class UserFullDeserializer implements JsonDeserializer<UserFullResponse> {

    private final Gson gson;

    public UserFullDeserializer(final Gson gson) {
        this.gson = gson;
    }

    @Override
    public UserFullResponse deserialize(final JsonElement jsonElement,
                                        final Type typeOfT,
                                        final JsonDeserializationContext context) throws JsonParseException {
        return gson.fromJson(jsonElement.toString(), UserFullResponse.class);
    }
}
