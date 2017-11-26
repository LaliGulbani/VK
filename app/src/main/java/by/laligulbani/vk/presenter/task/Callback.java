package by.laligulbani.vk.presenter.task;


import java.util.List;

import by.laligulbani.vk.model.entity.message.Item;

public interface Callback {
    void setText(List<Item> listItem);
}
