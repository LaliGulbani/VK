package by.laligulbani.vk.model.db;

import static by.laligulbani.vk.model.context.ContextHolder.getContext;

public class DataBaseFactory {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "My Database";

    public static IDataBase getInstance() {
        return new SqLiteDataBase(getContext(), DB_NAME, null, DB_VERSION);
    }
}


