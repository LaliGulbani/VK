package by.laligulbani.vk.model.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

import by.laligulbani.vk.model.parser.deserializer.DialogDeserializer;
import by.laligulbani.vk.model.parser.wrappers.DialogResponse;

public class IParserFactory {

    private static IParser INSTANCE;

    public static IParser getInstance() {

        if (INSTANCE != null) {
            return INSTANCE;
        }

        final GsonBuilder gsonBuilder = new GsonBuilder();

        for (final Map.Entry<Class, JsonDeserializer> entry : getDeserializer().entrySet()) {
            gsonBuilder.registerTypeAdapter(entry.getKey(), entry.getValue());
        }

        INSTANCE = new GsonParser(gsonBuilder
                .setPrettyPrinting()
                .create());

        return INSTANCE;
    }

    private static Map<Class, JsonDeserializer> getDeserializer() {

        final Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Map<Class, JsonDeserializer> deserializerMap = new HashMap<>();
        deserializerMap.put(DialogResponse.class, new DialogDeserializer(gson));

        return deserializerMap;
    }
}
