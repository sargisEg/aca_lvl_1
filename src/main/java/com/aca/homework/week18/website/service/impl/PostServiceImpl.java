package com.aca.homework.week18.website.service.impl;

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

import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    private final PostRepository postRepository;
    private final UserService userService;


    public PostServiceImpl(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public Post create(CreatePostParams params) {
        Assert.notNull(params, "Post creation params should not be null");
        LOGGER.info("Creating post with provided params - {}", params);

        final User user = userService.findById(params.getUserId())
                .orElseThrow(() -> {
                    throw new UserNotFoundException(params.getUserId());
                });

        final Post postFromParams = new Post(
                params.getTitle(),
                params.getDescription(),
                user
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

    @Override
    public Optional<Post> findById(Long id) {
        Assert.notNull(id, "Id should not be null");
        LOGGER.info("Finding post with id - {}", id);

        final Optional<Post> optionalPost = postRepository.findById(id);

        LOGGER.info("Successfully found post with id - {}, result - {}", id, optionalPost);
        return optionalPost;
    }
}
