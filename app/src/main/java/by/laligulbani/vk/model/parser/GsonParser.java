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
import java.io.InputStreamReader;
import java.io.Reader;

import by.laligulbani.vk.entity.dialog.Dialog;
import by.laligulbani.vk.entity.dialog.DialogResponse;
import by.laligulbani.vk.entity.users.UserFull;
import by.laligulbani.vk.model.parser.typeadapter.DialogTypeAdapter;

public class GsonParser implements IParser {

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

        try (final Reader reader = new InputStreamReader(new ByteArrayInputStream(is.getBytes()))) {
            return gson.fromJson(reader, mClass);
        } catch (final IOException e) {
            throw new RuntimeException("Trouble with parsing", e);
        }
    }
}
