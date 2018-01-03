package by.laligulbani.vk.model.service.messages;

import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.parser.IParser;
import by.laligulbani.vk.model.service.AbstractService;

public class MessageService extends AbstractService {

    MessageService(final IClient client,
                   final IParser parser) {
        super(parser, client);
    }


}

