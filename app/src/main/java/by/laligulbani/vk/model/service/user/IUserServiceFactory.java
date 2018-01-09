package by.laligulbani.vk.model.service.user;

import by.laligulbani.vk.model.client.IClientFactory;
import by.laligulbani.vk.model.db.IDataBaseFactory;
import by.laligulbani.vk.model.parser.IParserFactory;

public class IUserServiceFactory {

    private static IUserService INSTANCE = new UserService(
            IClientFactory.getInstance(),
            IParserFactory.getInstance(),
            IDataBaseFactory.getInstance());

    public static IUserService getInstance() {
        return INSTANCE;
    }
}
