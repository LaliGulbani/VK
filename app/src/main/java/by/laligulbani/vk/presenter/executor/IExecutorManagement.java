package by.laligulbani.vk.presenter.executor;


import java.util.concurrent.Callable;

public interface IExecutorManagement<T>{

    T execute(Callable<T> callable);
}
