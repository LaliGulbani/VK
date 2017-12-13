package by.laligulbani.vk.model.db;

public class DataBaseFactory {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "My Database";

    public static IDataBase getInstance() {
        return new SqLiteDataBase(null, DB_NAME, null, DB_VERSION);
    }
}


