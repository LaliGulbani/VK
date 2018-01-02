package by.laligulbani.vk.model.converter;

import by.laligulbani.vk.entity.users.UserFull;

public class FriendsConverter implements IConverter<UserFull> {

    @Override
    public UserFull convert(final UserFull source) {
        // TODO: 28.12.2017 добавить код айди в друга
        return source;
    }
}
