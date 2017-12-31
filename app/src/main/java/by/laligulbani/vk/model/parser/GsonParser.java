package by.laligulbani.vk.model.parser;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import by.laligulbani.vk.entity.messages.MessageResponse;

public class GsonParser implements IParser {

    private Gson gson;

    GsonParser() {
        this.gson = new GsonBuilder()
                .setLenient()
                .create();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public <T> T parse(final InputStream is, final Class<T> mClass) {

        try (final Reader reader = new BufferedReader(new InputStreamReader(is))) {

            final String str = normalize(IOUtils.toString(reader), mClass);

            return gson.fromJson(str, mClass);

        } catch (IOException | JSONException e) {
            throw new RuntimeException("Trouble with parsing", e);
        }
    }

    // TODO: 21-Dec-17 use gson type adapter
    private <T> String normalize(final String source, final Class<T> mClass) throws JSONException {

        if (mClass.equals(MessageResponse.class)) {
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
        }

        return "{}";
    }
}
