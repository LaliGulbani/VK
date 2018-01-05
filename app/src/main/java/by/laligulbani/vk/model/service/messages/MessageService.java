package by.laligulbani.vk.model.service.messages;

import java.util.List;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.parser.IParser;
import by.laligulbani.vk.model.service.AbstractService;

public class MessageService extends AbstractService {

    MessageService(final IClient client,
                   final IParser parser) {
        super(parser, client);
    }

    public List<Message> getMessage(final String token, final String id) {

        final String sb = Api.MESSAGE_HISTORY_GET
                + id
                + "&"
                + "access_token=" + token
                + "&"
                + "count=100";

        final List<Message> messages = execute(sb, MessageResponse.class).getMessage();

        return messages;

    }

    public void sendMessage (final String token, final String id){

        final String sb = Api.SEND_MESSAGE
                + id
                + "&"
                + "access_token=" + token;

    }
}

