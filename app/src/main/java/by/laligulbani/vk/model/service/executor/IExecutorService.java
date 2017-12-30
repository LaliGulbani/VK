package by.laligulbani.vk.model.service.executor;

import android.os.AsyncTask;

import java.util.Collection;
import java.util.concurrent.Future;

public interface IExecutorService {
    void executeOnExecutor(AsyncTask task);

    Future<?> submit(Runnable task);

    void invokeAll(Collection<Runnable> tasks);
}
