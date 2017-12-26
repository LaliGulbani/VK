package by.laligulbani.vk.model.service.image.cache;

import android.graphics.Bitmap;
import android.os.StatFs;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import by.laligulbani.vk.model.service.image.cache.assistent.IDiskCacheAssistant;

import static java.lang.System.currentTimeMillis;
import static java.util.Arrays.sort;

public class BaseIDiskCache implements IDiskCache {

    private static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;

    private static final int DEFAULT_COMPRESS_QUALITY = 80;
    private static final int BUFFER_SIZE = 4096;

    private static final String IMAGE_CACHE_DIR_NAME = "IMAGE_CACHE";

    private static final int MIN_DISK_CACHE_SIZE = 5 * 1024 * 1024;
    private static final int MAX_DISK_CACHE_SIZE = 50 * 1024 * 1024;

    private final IDiskCacheAssistant assistentInstance;

    private final File cacheDir;
    private final long cacheSize;

    BaseIDiskCache(final IDiskCacheAssistant assistentInstance, final File target) {

        this.assistentInstance = assistentInstance;

        this.cacheDir = new File(target, IMAGE_CACHE_DIR_NAME);
        this.cacheDir.setWritable(true);
        if (!cacheDir.exists()) {
            this.cacheDir.mkdirs();
        }

        if (!cacheDir.exists() || !cacheDir.canWrite()) {
            throw new IllegalStateException("Can't create dir for images");
        }

        this.cacheSize = calculateDiskCacheSize(cacheDir);
        freeSpaceIfRequired();
    }

    @Override
    public File get(final String url) {

        final File file = getFile(url);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (final IOException e) {
                throw new IllegalArgumentException("Could't create file", e);
            }
        }

        return file;
    }

    private File getFile(String url) {
        return new File(cacheDir, assistentInstance.getName(url));
    }

    @Override
    public void save(final String url, final Bitmap bitmap) {

        final File imageFile = get(url);

        try (final OutputStream os = new BufferedOutputStream(new FileOutputStream(imageFile), BUFFER_SIZE)) {
            bitmap.compress(DEFAULT_COMPRESS_FORMAT, DEFAULT_COMPRESS_QUALITY, os);
            imageFile.setLastModified(currentTimeMillis());
        } catch (final IOException e) {
            throw new IllegalArgumentException("Could't read file", e);
        }
    }

    @Override
    public boolean contain(final String url) {
        return getFile(url).exists();
    }

    private void freeSpaceIfRequired() {

        long currentCacheSize = getCurrentCacheSize();

        if (currentCacheSize > cacheSize) {

            final File[] files = cacheDir.listFiles();

            sort(files, (lhs, rhs) -> Long.valueOf(lhs.lastModified()).compareTo(rhs.lastModified()));

            int i = 0;
            do {
                final File f = files[i];
                final long length = f.length();
                if (f.delete()) {
                    currentCacheSize -= length;
                }
                i++;
            } while (currentCacheSize > cacheSize);
        }

    }

    private long getCurrentCacheSize() {
        long currentSize = 0;
        for (final File f : cacheDir.listFiles()) {
            currentSize += f.length();
        }
        return currentSize;
    }

    private long calculateDiskCacheSize(final File dir) {

        final StatFs statFs = new StatFs(dir.getAbsolutePath());
        final long blockCount = statFs.getBlockCount();
        final long size = blockCount * statFs.getBlockSize() / 50;

        return Math.max(Math.min(size, MAX_DISK_CACHE_SIZE), MIN_DISK_CACHE_SIZE);
    }
}
