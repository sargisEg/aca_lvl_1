package com.aca.homework.week18.website.service.impl;

import com.aca.homework.week18.website.entity.Image;
import com.aca.homework.week18.website.repository.ImageRepository;
import com.aca.homework.week18.website.service.core.CreateImageParams;
import com.aca.homework.week18.website.service.core.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Optional;

public class ImageServiceImpl implements ImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageServiceImpl.class);

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image create(CreateImageParams params) {
        Assert.notNull(params, "Image creation params should not be null");
        LOGGER.info("Creating image with provided params - {}", params);

        final Image imageFromParams = new Image(params.getBlobId());

        final Image image = imageRepository.save(imageFromParams);

        LOGGER.info("Successfully created image with provided params - {}, result - {}", params, image);
        return image;
    }

    @Override
    public Optional<Image> findById(Long id) {
        Assert.notNull(id, "Image id should not be null");
        LOGGER.info("Finding image with id - {}", id);

        final Optional<Image> optionalImage = imageRepository.findById(id);

        LOGGER.info("Successfully found an image with id - {}, result - {}", id, optionalImage);
        return optionalImage;
    }

    @Override
    public Optional<Image> findByBlobId(String blobId) {
        Assert.notNull(blobId, "Image blob id should not be null");
        LOGGER.info("Finding image with blob id - {}", blobId);

        final Optional<Image> optionalImage = imageRepository.findByBlobId(blobId);

        LOGGER.info("Successfully found an image with blob id - {}, result - {}", blobId, optionalImage);
        return optionalImage;
    }
}
