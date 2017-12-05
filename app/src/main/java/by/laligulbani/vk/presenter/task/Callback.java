package by.laligulbani.vk.presenter.task;

import java.util.List;

import by.laligulbani.vk.entity.message_list.Item;

public interface Callback {
    void setText(List<Item> listMessage);
}
