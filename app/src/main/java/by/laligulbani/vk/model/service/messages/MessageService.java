package by.laligulbani.vk.model.service.messages;

import java.util.List;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.entity.message.LongPollServer;
import by.laligulbani.vk.entity.message.MessageHistory;
import by.laligulbani.vk.entity.message.MessageResponseServer;
import by.laligulbani.vk.entity.message.NewMessage;
import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.parser.IParser;
import by.laligulbani.vk.model.parser.wrappers.MessageResponse;
import by.laligulbani.vk.model.service.AbstractService;

public class MessageService extends AbstractService implements IMessageService {

    MessageService(final IClient client,
                   final IParser parser) {
        super(parser, client);
    }

    @Override
    public List<MessageHistory> getMessage(final String token, final String id) {

        final String sb = Api.MESSAGE_HISTORY_GET
                + id
                + "&"
                + "access_token=" + token
                + "&"
                + "count=100";

        final List<MessageHistory> messageHistory = execute(sb, MessageResponse.class).getMessageHistory();

        return messageHistory;

    }

    @Override
    public void sendMessage(final String token, final String id) {

        final String sb = Api.SEND_MESSAGE
                + id
                + "&"
                + "access_token=" + token;

    }

    @Override
    public List<NewMessage> getNewMessage(final String token) {

        String urlServer = "https://api.vk.com/method/messages.getLongPollServer"
                + "?"
                + "access_token="
                + token
                + "&need_pts=1&lp_version=2";

        String key = execute(urlServer, LongPollServer.class).getKey();
        String ts = execute(urlServer, LongPollServer.class).getTs();
        String server = execute(urlServer, LongPollServer.class).getServer();

        String urlNewMessage = "https://"
                + server
                + "?act=a_check&key="
                + key
                + "&ts="
                + ts
                + "&wait=25&mode=2&version=2";

        List<NewMessage> newMessages = execute(urlNewMessage, MessageResponseServer.class).getNewMessage();

        return newMessages;
    }
}

