package by.laligulbani.vk.model.facade.dialog;

import by.laligulbani.vk.entity.dialog.Dialog;
import by.laligulbani.vk.model.converter.IConverterFactory;
import by.laligulbani.vk.model.service.dialog.IDialogServiceFactory;
import by.laligulbani.vk.model.service.user.IUserServiceFactory;

public class IDialogFacadeFactory {

    public static IDialogFacade getInstance() {
        return new DialogFacade(
                IConverterFactory.getInstance(Dialog.class),
                IDialogServiceFactory.getInstance(),
                null,
                //IImageServiceFactory.getInstance(),
                IUserServiceFactory.getInstance());
    }
}
