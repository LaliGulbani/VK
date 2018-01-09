package by.laligulbani.vk.model.facade.user;

import java.util.List;

import by.laligulbani.vk.model.facade.dto.UserDto;
import by.laligulbani.vk.model.service.image.entity.ImageRequest;

public interface IUserFacade {

    List<UserDto> getFriends(String token);

    void getImage(ImageRequest request);

    List<UserDto> getFriendsOnline(String token);
}
