package by.laligulbani.vk.model.service.dialog;

import by.laligulbani.vk.model.client.IClientFactory;
import by.laligulbani.vk.model.db.IDataBaseFactory;
import by.laligulbani.vk.model.parser.IParserFactory;

public class IDialogServiceFactory {
    
    public static IDialogService getInstance() {
        return new DialogService(
                IClientFactory.getInstance(),
                IParserFactory.getInstance(),
                IDataBaseFactory.getInstance());
    }
}
