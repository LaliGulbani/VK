package by.laligulbani.vk.model.task;

import android.os.AsyncTask;

import by.laligulbani.vk.model.function.Consumer;
import by.laligulbani.vk.model.function.Supplier;

public class Task<T> extends AsyncTask<T, T, T> {

    private final Consumer<T> consumer;
    private final Supplier<T> supplier;

    public Task(final Supplier<T> supplier,
                final Consumer<T> consumer) {
        this.consumer = consumer;
        this.supplier = supplier;
    }

    public Task(final Supplier<T> supplier) {
        this(supplier, null);
    }

    @SafeVarargs
    @Override
    protected final T doInBackground(final T... params) {
        return supplier.get();
    }

    @Override
    protected void onPostExecute(final T result) {
        if (consumer != null) {
            consumer.accept(result);
        }
    }
}