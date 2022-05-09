package com.aca.homework.week18.website.service.impl;

import com.aca.homework.week18.website.entity.Image;
import com.aca.homework.week18.website.entity.Post;
import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.repository.PostRepository;
import com.aca.homework.week18.website.service.core.CreatePostParams;
import com.aca.homework.week18.website.service.core.ImageService;
import com.aca.homework.week18.website.service.core.PostService;
import com.aca.homework.week18.website.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.LinkedList;
import java.util.List;

public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    private final PostRepository postRepository;
    private final UserService userService;

    private final ImageService imageService;

    public PostServiceImpl(PostRepository postRepository, UserService userService, ImageService imageService) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.imageService = imageService;
    }

    @Override
    public Post create(CreatePostParams params) {
        Assert.notNull(params, "Post creation params should not be null");
        LOGGER.info("Creating post with provided params - {}", params);

        final User user = userService.findById(params.getUserId())
                .orElseThrow(() -> {
                    throw new UserNotFoundException(params.getUserId());
                });

        List<Image> images = new LinkedList<>();

        final List<Long> imagesId = params.getImages();

        imagesId.forEach(imageId -> {
            images.add(
                    imageService.findById(imageId)
                            .orElseThrow(() -> {
                                throw new ImageNotFoundException(imageId);
                            })
            );
        });

        final Post postFromParams = new Post(
                params.getTitle(),
                params.getDescription(),
                user,
                images
        );

        final Post post = postRepository.save(postFromParams);

        LOGGER.info("Successfully created post with provided params - {}, result - {}", params, post);
        return post;
    }

    @Override
    public List<Post> getAllPostsByUserUsername(String username) {
        Assert.hasText(username, "Username should not be null or empty");
        LOGGER.info("Getting all user posts with username - {}", username);

        final List<Post> posts = postRepository.findAllByUserUsername(username);

        LOGGER.info("Successfully got all user posts with username - {}, result - {}", username, posts);
        return posts;
    }
}
