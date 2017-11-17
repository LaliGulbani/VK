package by.laligulbani.vk.presenter.executor;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor implements IExecutorManagement{
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);
    @Override
    public Object execute(Callable callable) {
        return null;
    }
}
