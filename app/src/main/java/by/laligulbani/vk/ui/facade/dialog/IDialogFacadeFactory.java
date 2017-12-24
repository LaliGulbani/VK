package by.laligulbani.vk.ui.facade.dialog;

import by.laligulbani.vk.entity.messages.Dialog;
import by.laligulbani.vk.model.converter.IConverterFactory;
import by.laligulbani.vk.model.service.dialog.IDialogServiceFactory;
import by.laligulbani.vk.model.service.image.IImageServiceFactory;
import by.laligulbani.vk.model.service.user.IUserServiceFactory;

public class IDialogFacadeFactory {

    private static IDialogFacade INSTANCE = new DialogFacade(
            IConverterFactory.getInstance(Dialog.class),
            IDialogServiceFactory.getInstance(),
            IImageServiceFactory.getInstance(),
            IUserServiceFactory.getInstance());

    public static IDialogFacade getInstance() {
        return INSTANCE;
    }
}
