package by.laligulbani.vk.model.facade.dialog;

import java.util.List;

import by.laligulbani.vk.model.facade.dto.DialogDto;

public interface IDialogFacade {

    List<DialogDto> getDialogs(String token);
}
