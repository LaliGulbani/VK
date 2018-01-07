package by.laligulbani.vk.model.parser;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.Gson;

public class GsonParser implements IParser {

    private Gson gson;

    GsonParser(final Gson gson) {
        this.gson = gson;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public <T> T parse(final String json, final Class<T> mClass) {
        return gson.fromJson(json, mClass);
    }
}
