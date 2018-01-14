package by.laligulbani.vk.model.service.messages;

import by.laligulbani.vk.model.client.IClientFactory;
import by.laligulbani.vk.model.parser.IParserFactory;

public class IMessageServiceFactory {

    private static IMessageService INSTANCE = new MessageService(
            IClientFactory.getInstance(),
            IParserFactory.getInstance());

    public static IMessageService getInstance() {
        return INSTANCE;
    }
}
