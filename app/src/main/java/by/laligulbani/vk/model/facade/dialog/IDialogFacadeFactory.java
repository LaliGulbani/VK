package by.laligulbani.vk.model.facade.dialog;

import by.laligulbani.vk.model.service.dialog.IDialogServiceFactory;
import by.laligulbani.vk.model.service.image.IImageServiceFactory;
import by.laligulbani.vk.model.service.user.IUserServiceFactory;

public class IDialogFacadeFactory {

    private static IDialogFacade INSTANCE = new DialogFacade(
            IDialogServiceFactory.getInstance(),
            IImageServiceFactory.getInstance(),
            IUserServiceFactory.getInstance());

    public static IDialogFacade getInstance() {
        return INSTANCE;
    }
}
