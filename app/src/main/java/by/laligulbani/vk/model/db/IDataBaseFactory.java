package by.laligulbani.vk.model.db;

import static by.laligulbani.vk.model.util.ContextHolder.getContext;

public class IDataBaseFactory {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "My Database";

    public static IDataBase getInstance() {
        return new DataBase(getContext(), DB_NAME, null, DB_VERSION);
    }
}
