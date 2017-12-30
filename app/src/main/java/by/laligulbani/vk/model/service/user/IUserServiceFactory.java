package by.laligulbani.vk.model.service.user;

import by.laligulbani.vk.model.client.IClientFactory;
import by.laligulbani.vk.model.db.IDataBaseFactory;
import by.laligulbani.vk.model.parser.IParserFactory;
import by.laligulbani.vk.model.service.executor.IExecutorServiceFactory;
import by.laligulbani.vk.model.util.ContextHolder;

public class IUserServiceFactory {

    private static IUserService INSTANCE = new UserService(
            ContextHolder.getContext(),
            IClientFactory.getInstance(),
            IParserFactory.getInstance(),
            IDataBaseFactory.getInstance(),
            IExecutorServiceFactory.getInstance());

    public static IUserService getInstance() {
        return INSTANCE;
    }
}
