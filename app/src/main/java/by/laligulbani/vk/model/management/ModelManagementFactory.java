package by.laligulbani.vk.model.management;

import by.laligulbani.vk.model.client.IClientFactory;
import by.laligulbani.vk.model.parser.IParserFactory;

public class ModelManagementFactory {

    private static final Object LOCK = new Object();
    private static IModelManagement INSTANCE;

    public static IModelManagement getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ModelManager(IClientFactory.getInstance(), IParserFactory.getInstance());
                }
            }

        }
        return INSTANCE;
    }
}
