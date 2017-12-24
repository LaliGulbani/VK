package by.laligulbani.vk.model.service.user;

import by.laligulbani.vk.model.client.IClientFactory;
import by.laligulbani.vk.model.context.ContextHolder;
import by.laligulbani.vk.model.db.DataBaseFactory;
import by.laligulbani.vk.model.parser.IParserFactory;

public class IUserServiceFactory {

    private static IUserService INSTANCE = new UserService(
            ContextHolder.getContext(),
            IClientFactory.getInstance(),
            IParserFactory.getInstance());

    public static IUserService getInstance() {
        return INSTANCE;
    }
}
