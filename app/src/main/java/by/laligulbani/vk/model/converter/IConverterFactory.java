package by.laligulbani.vk.model.converter;

import by.laligulbani.vk.entity.friends.Friends;
import by.laligulbani.vk.entity.messages.Dialog;

public class IConverterFactory {

    public static <R, T extends IConverter<R>> T getInstance(final Class<R> aClass) {

        if (aClass == null) {
            throw new IllegalArgumentException("input params should not be null");
        }

        if (aClass.equals(Friends.class)) {
            return (T) new FriendsConverter();
        } else if (aClass.equals(Dialog.class)) {
            return (T) new DialogConverter();
        }

        throw new UnsupportedOperationException("this class is unsupported");
    }
}
