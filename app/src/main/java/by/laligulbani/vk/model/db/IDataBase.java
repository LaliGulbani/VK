package by.laligulbani.vk.model.db;

import java.util.Collection;
import java.util.List;

import by.laligulbani.vk.entity.messages.Dialog;

public interface IDataBase {

    void addDialog(Dialog dialog);

    void addDialogs(Collection<Dialog> dialogs);

    List<Dialog> getDialogs();

    Dialog getLastDialog();

    Dialog getDialogById(int id);

    Long getDialogCount();
}