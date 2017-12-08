package by.laligulbani.vk.presenter.task;

import java.util.List;

import by.laligulbani.vk.entity.messages.Message;

public interface Callback {
    void setText(List<Message> listMessage);
}
