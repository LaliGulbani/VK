package by.laligulbani.vk.model.parser;


import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;

public class GsonParser<T> implements IParser {

    private final InputStreamReader reader;
    private final Class<T> mClass;

    public GsonParser(final InputStream mIntputStream, final Class<T> mClass) {
        this.mClass = mClass;
        this.reader = new InputStreamReader(mIntputStream);
    }

    @Override
    public T parse() {
        return new Gson().fromJson(reader, mClass);
    }
}
