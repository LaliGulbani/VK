package by.laligulbani.vk;

import android.app.Application;

import by.laligulbani.vk.model.service.executor.IExecutorServiceFactory;
import by.laligulbani.vk.model.util.ContextHolder;

public class VKApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ContextHolder.setContext(this.getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        IExecutorServiceFactory.getInstance().shutdown();
    }
}
