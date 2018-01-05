package by.laligulbani.vk.model.service.dialog;

import by.laligulbani.vk.model.client.IClientFactory;
import by.laligulbani.vk.model.db.IDataBaseFactory;
import by.laligulbani.vk.model.parser.IParserFactory;

public class IDialogServiceFactory {

    private static IDialogService INSTANCE = new DialogService(
            IClientFactory.getInstance(),
            IParserFactory.getInstance(),
            IDataBaseFactory.getInstance());

    public static IDialogService getInstance() {
        return INSTANCE;
    }
}
