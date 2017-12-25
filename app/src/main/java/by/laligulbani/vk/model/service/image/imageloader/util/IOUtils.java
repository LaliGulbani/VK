package by.laligulbani.vk.model.service.image.imageloader.util;

import android.util.Log;

import java.io.Closeable;
import java.io.IOException;

public final class IOUtils {

    private static final String LOG_TAG = IOUtils.class.getSimpleName();

    public static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                Log.e(LOG_TAG, "Could not close stream");
            }
        }
    }

}
