package by.laligulbani.vk.model.facade.dialog;

import java.util.List;

import by.laligulbani.vk.model.facade.dto.DialogDto;
import by.laligulbani.vk.model.service.image.entity.ImageRequest;

public interface IDialogFacade {

    List<DialogDto> getDialogs(String token);

    void getImage(ImageRequest request);
}
