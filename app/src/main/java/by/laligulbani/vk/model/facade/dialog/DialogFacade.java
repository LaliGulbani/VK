package by.laligulbani.vk.model.facade.dialog;

import java.util.ArrayList;
import java.util.List;

import by.laligulbani.vk.entity.dialog.Dialog;
import by.laligulbani.vk.entity.users.User;
import by.laligulbani.vk.model.converter.IConverter;
import by.laligulbani.vk.model.facade.dto.DialogDto;
import by.laligulbani.vk.model.service.dialog.IDialogService;
import by.laligulbani.vk.model.service.image.IImageService;
import by.laligulbani.vk.model.service.image.entity.ImageRequest;
import by.laligulbani.vk.model.service.user.IUserService;


public class DialogFacade implements IDialogFacade {

    private final IConverter<Dialog> converter;
    private final IDialogService dialogService;
    private final IImageService imageService;
    private final IUserService userService;

    DialogFacade(final IConverter<Dialog> converter,
                 final IDialogService dialogService,
                 final IImageService imageService,
                 final IUserService userService) {
        this.converter = converter;
        this.dialogService = dialogService;
        this.imageService = imageService;
        this.userService = userService;
    }

    @Override
    public List<DialogDto> getDialogs(final String token) {

        final List<Dialog> dialogs = dialogService.getDialogs(token);

        final List<DialogDto> result = new ArrayList<>();
        for (final Dialog message : dialogs) {
            final Dialog dialog = converter.convert(message);
            final User user = userService.getUser(dialog.getId());

            result.add(new DialogDto(
                    user.getFirstName() + " " + user.getLastName(),
                    dialog.getDate(),
                    dialog.getBody(),
                    dialog.getImage()));
        }
        return result;
    }

    @Override
    public void getImage(final ImageRequest request) {
//        imageService.enqueue(request);
    }
}
