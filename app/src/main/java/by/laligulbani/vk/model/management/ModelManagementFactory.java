package by.laligulbani.vk.model.management;

import by.laligulbani.vk.model.client.IClientFactory;
import by.laligulbani.vk.model.db.DataBaseFactory;
import by.laligulbani.vk.model.parser.IParserFactory;

public class ModelManagementFactory {

    private static IModelManagement INSTANCE = new ModelManager(
            IClientFactory.getInstance(),
            IParserFactory.getInstance(),
            DataBaseFactory.getInstance());

    public static IModelManagement getInstance() {
        return INSTANCE;
    }
}
