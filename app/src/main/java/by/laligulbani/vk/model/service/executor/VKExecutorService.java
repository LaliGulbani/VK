package by.laligulbani.vk.model.service.executor;

import android.os.AsyncTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VKExecutorService implements IExecutorService {

    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    @Override
    public void executeOnExecutor(final AsyncTask task) {
        task.executeOnExecutor(executorService);
    }

    @Override
    protected void finalize() throws Throwable {
        executorService.shutdown();
        super.finalize();
    }
}
