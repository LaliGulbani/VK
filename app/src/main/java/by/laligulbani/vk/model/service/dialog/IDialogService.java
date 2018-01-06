package by.laligulbani.vk.model.service.dialog;

import java.util.List;

import by.laligulbani.vk.entity.dialog.Dialog;

public interface IDialogService {
    
    List<Dialog> getDialogs(String token);
}
