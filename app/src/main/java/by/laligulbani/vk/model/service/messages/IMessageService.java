package by.laligulbani.vk.model.service.messages;

import java.util.List;

import by.laligulbani.vk.entity.message.MessageHistory;
import by.laligulbani.vk.entity.message.NewMessage;

public interface IMessageService {

  List<MessageHistory> getMessage(String token, String id);

  void sendMessage (String token, String id);

  List<NewMessage> getNewMessage(String token);
}
