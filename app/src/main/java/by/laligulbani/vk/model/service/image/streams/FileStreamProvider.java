package by.laligulbani.vk.model.service.image.streams;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileStreamProvider implements IStreamProvider<File> {

    private static final int BUFFER_SIZE = 4096;

    @Override
    public InputStream get(final File file) throws IOException {
        return new BufferedInputStream(new FileInputStream(file), BUFFER_SIZE);
    }
}
