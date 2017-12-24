package by.laligulbani.vk.ui.task;

import android.os.AsyncTask;

import by.laligulbani.vk.model.function.Consumer;
import by.laligulbani.vk.model.function.Runnable;

public class Task<T> extends AsyncTask<T, T, T> {

    private final Consumer<T> consumer;
    private final Runnable<T> runnable;

    public Task(final Runnable<T> runnable,
                final Consumer<T> consumer) {
        this.consumer = consumer;
        this.runnable = runnable;
    }

    @Override
    protected T doInBackground(final T... params) {
        return runnable.run();
    }

    @Override
    protected void onPostExecute(final T result) {
        consumer.accept(result);
    }
}