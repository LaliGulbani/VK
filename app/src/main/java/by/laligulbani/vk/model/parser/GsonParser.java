package by.laligulbani.vk.model.parser;


import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class GsonParser implements IParser {

    private Gson gson;

    public GsonParser() {
        this.gson = new GsonBuilder()
                .setLenient()
                .create();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public Object parse(InputStream mIntputStream, Class mClass) {
        try (final Reader reader = new InputStreamReader(mIntputStream)) {
            return gson.fromJson(reader, mClass);
        } catch (IOException e) {
            throw new RuntimeException("Trouble with parsing", e);
        }
    }
}
