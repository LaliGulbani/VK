package by.laligulbani.vk.model.service.image;

import by.laligulbani.vk.model.service.image.entity.ImageRequest;

public interface IImageService {
    void enqueue(ImageRequest request);
}
