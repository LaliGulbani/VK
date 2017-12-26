package by.laligulbani.vk.model.service.executor;

public class IExecutorServiceFactory {

    private static final IExecutorService INSTANCE = new VKExecutorService();

    public static IExecutorService getInstance() {
        return INSTANCE;
    }
}
