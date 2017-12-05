package by.laligulbani.vk.presenter.task;

import java.util.List;

import by.laligulbani.vk.entity.message_list.Message;

public interface Callback {
    void setText(List<Message> listMessage);
}
