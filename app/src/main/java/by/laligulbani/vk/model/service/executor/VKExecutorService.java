package by.laligulbani.vk.model.service.executor;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VKExecutorService implements IExecutorService {

    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    @Override
    public void executeOnExecutor(final AsyncTask task) {
        task.executeOnExecutor(executorService);
    }

    @Override
    public Future<?> submit(final Runnable task) {
        return executorService.submit(task);
    }

    @Override
    public void invokeAll(final Collection<Runnable> tasks) {

        final List<Future> futures = new ArrayList<>();

        for (final Runnable runnable : tasks) {
            futures.add(executorService.submit(runnable));
        }

        while (true) {
            int count = 0;
            for (final Future future : futures) {
                if (future.isDone()) {
                    count++;
                }
            }

            if (count == futures.size()) {
                break;
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        executorService.shutdown();
        super.finalize();
    }
}
