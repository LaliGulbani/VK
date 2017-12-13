package by.laligulbani.vk.model.db;

import android.content.Context;

public class DataBaseFactory {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "My Database";
    public static IDataBase getInstance(Context context) {
        return new SqLiteDataBase(context,DB_NAME, null,DB_VERSION);
    }
}


