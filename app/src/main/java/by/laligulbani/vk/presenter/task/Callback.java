package by.laligulbani.vk.presenter.task;


import java.util.List;

import by.laligulbani.vk.model.entity.message.Item;
import by.laligulbani.vk.presenter.recycleViewMessanger.Messenger;

public interface Callback {
    void setText(List<Messenger listItem);
}
