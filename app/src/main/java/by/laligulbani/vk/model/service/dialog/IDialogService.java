package by.laligulbani.vk.model.service.dialog;

import java.util.List;

import by.laligulbani.vk.entity.messages.Dialog;

public interface IDialogService {
    
    List<Dialog> getDialogs(String token);
}
