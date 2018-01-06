package by.laligulbani.vk.model.converter;

import by.laligulbani.vk.entity.dialog.Dialog;
import by.laligulbani.vk.entity.users.UserFull;

public class IConverterFactory {

    public static <R, T extends IConverter<R>> T getInstance(final Class<R> aClass) {

        if (aClass == null) {
            throw new IllegalArgumentException("input params should not be null");
        }

        if (aClass.equals(UserFull.class)) {
            return (T) new FriendsConverter();
        } else if (aClass.equals(Dialog.class)) {
            return (T) new DialogConverter();
        }

        throw new UnsupportedOperationException("this class is unsupported");
    }
}
