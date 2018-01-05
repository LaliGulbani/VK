package by.laligulbani.vk.model.parser;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import by.laligulbani.vk.entity.friends.FriendsResponse;
import by.laligulbani.vk.entity.messages.DialogResponse;
import by.laligulbani.vk.entity.users.UserFull;
import by.laligulbani.vk.model.parser.typeadapter.DialogTypeAdapter;

import static java.nio.charset.Charset.defaultCharset;

public class GsonParser implements IParser {

    private static final int BUFFER_SIZE = 1024;

    private Gson gson;

    GsonParser() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(DialogResponse.class, new DialogTypeAdapter())
                .setPrettyPrinting()
                .create();


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public <T> T parse(final String is, final Class<T> mClass) {

        final String source = getSourceString(is);

        try (final Reader reader = new InputStreamReader(new ByteArrayInputStream(normalize(source, mClass).getBytes()))) {
            return gson.fromJson(reader, mClass);
        } catch (final IOException | JSONException e) {
            throw new RuntimeException("Trouble with parsing", e);
        }
    }

    private String getSourceString(final String is) {

        try (final Reader reader = new InputStreamReader(is, defaultCharset())) {

            final StringBuilder sb = new StringBuilder();

            final char[] buffer = new char[BUFFER_SIZE];

            int i;
            do {
                i = reader.read(buffer, 0, buffer.length);
                sb.append(buffer);
            } while (i >= 0);

            return sb.toString();

        } catch (final IOException e) {
            throw new RuntimeException("Trouble with parsing", e);
        }
    }

    private <T> String normalize(final String source, final Class<T> mClass) throws JSONException {

        if (mClass.equals(DialogResponse.class)) {
            final JSONObject object = new JSONObject(source);
            final JSONArray array = object.getJSONArray("response");

            final JSONArray items = new JSONArray();
            for (int i = 1; i < array.length(); i++) {
                items.put(array.get(i));
            }

            final JSONObject response = new JSONObject();
            response.put("count", array.get(0));
            response.put("items", items);

            return response.toString();
        } else if (FriendsResponse.class.equals(mClass)) {
            return source.substring(0, source.indexOf("]}") + 2);
        } else if (UserFull.class.equals(mClass)) {
            final JSONObject object = new JSONObject(source.substring(0, source.indexOf("]}") + 2));
            return object.getJSONArray("response").get(0).toString();
        }

        return "{}";
    }
}
