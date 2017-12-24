package by.laligulbani.vk.model.context;

import android.content.Context;

public class ContextHolder {

    private static Context context;

    public static Context getContext() {
        if (context == null) {
            throw new RuntimeException("Context does not be initiated");
        }
        return context;
    }

    public static void setContext(final Context context) {
        if (ContextHolder.context == null) {
            ContextHolder.context = context;
        }
    }
}