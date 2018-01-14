package by.laligulbani.vk.model.facade.dialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.laligulbani.vk.entity.dialog.Dialog;
import by.laligulbani.vk.entity.users.UserFull;
import by.laligulbani.vk.model.facade.dto.DialogDto;
import by.laligulbani.vk.model.service.dialog.IDialogService;
import by.laligulbani.vk.model.service.image.IImageService;
import by.laligulbani.vk.model.service.image.entity.ImageRequest;
import by.laligulbani.vk.model.service.user.IUserService;

import static java.lang.String.format;
import static java.util.Locale.getDefault;

public class DialogFacade implements IDialogFacade {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("h:mm a", getDefault());

    private final IDialogService dialogService;
    private final IImageService imageService;
    private final IUserService userService;

    DialogFacade(final IDialogService dialogService,
                 final IImageService imageService,
                 final IUserService userService) {
        this.dialogService = dialogService;
        this.imageService = imageService;
        this.userService = userService;
    }

    @Override
    public List<DialogDto> getDialogs(final String token) {

        final List<Dialog> dialogs = dialogService.getDialogs(token);

        final List<DialogDto> result = new ArrayList<>();

        for (final Dialog dialog : dialogs) {

            String photo50 = dialog.getPhoto_50();

            final UserFull user = userService.getUser(dialog.getUid());

            if (photo50 == null && user != null) {
                photo50 = user.getPhoto50();
            }

            String title = dialog.getTitle();

            if (title == null) {
                title = user == null ? "No name" : format("%s %s", user.getFirstName(), user.getLastName());
            }

            result.add(new DialogDto(
                    dialog.getUid(),
                    title,
                    DATE_FORMAT.format(new Date(1000 * Long.valueOf(dialog.getDate()))),
                    dialog.getBody(),
                    photo50));
        }
        return result;
    }

    @Override
    public void getImage(final ImageRequest request) {
        imageService.enqueue(request);
    }
}
