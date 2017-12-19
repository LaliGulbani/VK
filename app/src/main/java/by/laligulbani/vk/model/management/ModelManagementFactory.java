package by.laligulbani.vk.model.management;

import by.laligulbani.vk.model.client.IClientFactory;
import by.laligulbani.vk.model.db.DataBaseFactory;
import by.laligulbani.vk.model.parser.IParserFactory;
import by.laligulbani.vk.model.context.ContextHolder;

public class ModelManagementFactory {

    private static IModelManagement INSTANCE = new ModelManager(
            ContextHolder.getContext(),
            IClientFactory.getInstance(),
            IParserFactory.getInstance(),
            DataBaseFactory.getInstance());

    public static IModelManagement getInstance() {
        return INSTANCE;
    }
}
