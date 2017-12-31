package by.laligulbani.vk.presenter.task;

import android.os.AsyncTask;

public class GetMessageTask1<Input, Result> extends AsyncTask<Input, Void, Result> {

    private final Function<Input, Result> function;
    private final Consumer<Result> consumer;

    public GetMessageTask1(Function<Input, Result> function,
                           final Consumer<Result> consumer) {
        this.function = function;
        this.consumer = consumer;
    }

    @Override
    protected Result doInBackground(final Input... params) {
        return function.invoke(params[0]);
    }

    @Override
    protected void onPostExecute(final Result result) {
        consumer.accept(result);
    }

    public interface Function<T, R> {
        R invoke(T t);
    }
}