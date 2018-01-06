package by.laligulbani.vk.model.service.user;

import by.laligulbani.vk.model.client.IClientFactory;
import by.laligulbani.vk.model.db.IDataBaseFactory;
import by.laligulbani.vk.model.parser.IParserFactory;

public class IUserServiceFactory {

    public static IUserService getInstance() {
        return new UserService(
                IClientFactory.getInstance(),
                IParserFactory.getInstance(),
                IDataBaseFactory.getInstance());
    }
}
