package by.laligulbani.vk.model.db;

import static by.laligulbani.vk.model.context.ContextHolder.getContext;

public class IDataBaseFactory {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "My Database";

    private static final DataBase INSTANCE = new DataBase(getContext(), DB_NAME, null, DB_VERSION);

    public static IDataBase getInstance() {
        return INSTANCE;
    }
}


