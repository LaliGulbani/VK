package by.laligulbani.vk.ui.task;

import android.os.AsyncTask;

import by.laligulbani.vk.model.function.Consumer;
import by.laligulbani.vk.model.function.Supplier;

public class Task<T> extends AsyncTask<Void, T, T> {

    private final Consumer<T> consumer;
    private final Supplier<T> supplier;

    public Task(final Supplier<T> supplier,
                final Consumer<T> consumer) {
        this.consumer = consumer;
        this.supplier = supplier;
    }

    @Override
    protected T doInBackground(final Void... params) {
        return supplier.get();
    }

    @Override
    protected void onPostExecute(final T result) {
        consumer.accept(result);
    }
}