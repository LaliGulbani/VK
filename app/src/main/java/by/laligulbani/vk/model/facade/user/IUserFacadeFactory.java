package by.laligulbani.vk.model.facade.user;

import by.laligulbani.vk.model.service.dialog.IDialogServiceFactory;
import by.laligulbani.vk.model.service.image.IImageServiceFactory;
import by.laligulbani.vk.model.service.user.IUserServiceFactory;

public class IUserFacadeFactory {

    private static IUserFacade INSTANCE = new UserFacade(
            IDialogServiceFactory.getInstance(),
            IImageServiceFactory.getInstance(),
            IUserServiceFactory.getInstance());

    public static IUserFacade getInstance() {
        return INSTANCE;
    }
}
