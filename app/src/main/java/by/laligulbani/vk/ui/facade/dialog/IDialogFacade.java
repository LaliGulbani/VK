package by.laligulbani.vk.ui.facade.dialog;

import java.util.List;

import by.laligulbani.vk.ui.facade.dto.DialogDto;

public interface IDialogFacade {

    List<DialogDto> getDialogs(String token);
}
