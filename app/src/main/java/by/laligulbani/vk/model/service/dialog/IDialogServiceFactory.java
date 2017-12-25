package by.laligulbani.vk.model.service.dialog;

import by.laligulbani.vk.model.client.IClientFactory;
import by.laligulbani.vk.model.db.IDataBaseFactory;
import by.laligulbani.vk.model.parser.IParserFactory;
import by.laligulbani.vk.model.context.ContextHolder;

public class IDialogServiceFactory {

    private static IDialogService INSTANCE = new DialogService(
            ContextHolder.getContext(),
            IClientFactory.getInstance(),
            IParserFactory.getInstance(),
            IDataBaseFactory.getInstance());

    public static IDialogService getInstance() {
        return INSTANCE;
    }
}
