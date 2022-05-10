package com.aca.homework.week18.website.service.impl;

import com.aca.homework.week18.website.entity.Image;
import com.aca.homework.week18.website.entity.Post;
import com.aca.homework.week18.website.repository.ImageRepository;
import com.aca.homework.week18.website.service.core.CreateImageParams;
import com.aca.homework.week18.website.service.core.ImageService;
import com.aca.homework.week18.website.service.core.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

public class ImageServiceImpl implements ImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageServiceImpl.class);

    private final ImageRepository imageRepository;
    private final PostService postService;

    public ImageServiceImpl(ImageRepository imageRepository, PostService postService) {
        this.imageRepository = imageRepository;
        this.postService = postService;
    }

    @Override
    public Image create(CreateImageParams params) {
        Assert.notNull(params, "Image creation params should not be null");
        LOGGER.info("Creating image with provided params - {}", params);

        final Post post = postService.findById(params.getPostId())
                .orElseThrow(() -> {
                    throw new PostNotFoundException(params.getPostId());
                });
        final Image imageFromParams = new Image(params.getBlobId(), post);

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
    public List<Image> findByPostId(Long id) {
        Assert.notNull(id, "Image post id should not be null");
        LOGGER.info("Finding image with post id - {}", id);

        final List<Image> optionalImage = imageRepository.findByPostId(id);

        LOGGER.info("Successfully found an image with post id - {}, result - {}", id, optionalImage);
        return optionalImage;
    }
}
