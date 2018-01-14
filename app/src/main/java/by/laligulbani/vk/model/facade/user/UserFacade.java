package by.laligulbani.vk.model.facade.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.laligulbani.vk.entity.users.UserFull;
import by.laligulbani.vk.model.facade.dto.UserDto;
import by.laligulbani.vk.model.service.dialog.IDialogService;
import by.laligulbani.vk.model.service.image.IImageService;
import by.laligulbani.vk.model.service.image.entity.ImageRequest;
import by.laligulbani.vk.model.service.user.IUserService;

public class UserFacade implements IUserFacade {


    private final IImageService imageService;
    private final IUserService userService;

    UserFacade(final IDialogService dialogService,
               final IImageService imageService,
               final IUserService userService) {

        this.imageService = imageService;
        this.userService = userService;
    }

    @Override
    public List<UserDto> getFriends(final String token) {

        final List<UserFull> dialogs = userService.getFriends(token);

        final List<UserDto> result = new ArrayList<>();
        for (final UserFull user : dialogs) {
            result.add(new UserDto(user.getFirstName(), user.getLastName(), user.getPhoto50()));
        }
        return result;
    }

    @Override
    public void getImage(final ImageRequest request) {
        imageService.enqueue(request);
    }

    @Override
    public List<UserDto> getFriendsOnline(String token) {
        return Collections.emptyList();
    }
}
