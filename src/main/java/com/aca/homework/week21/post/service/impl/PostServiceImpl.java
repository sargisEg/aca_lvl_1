package com.aca.homework.week21.post.service.impl;

import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.repository.PostRepository;
import com.aca.homework.week21.post.service.core.CreatePostParams;
import com.aca.homework.week21.post.service.core.PostService;
import com.aca.homework.week21.post.service.core.RandomFactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post create(CreatePostParams params) {
        Assert.notNull(params, "Post creation params should not be null");
        LOGGER.info("Creating post with provided params - {}", params);

        final Post postFromParams = new Post(
                params.getCreationDate(),
                params.getContext(),
                params.getCreatorName()
        );

        final Post post = postRepository.save(postFromParams);

        LOGGER.info("Successfully created post with provided params - {}, result - {}", params, post);
        return post;
    }

    @Override
    public List<Post> findAll() {
        LOGGER.info("Finding all posts");

        final List<Post> posts = postRepository.findAll();

        LOGGER.info("Successfully found all posts result - {}", posts);
        return posts;
    }

    @Override
    public Optional<Post> findById(Long id) {
        Assert.notNull(id, "Post id should not be null");
        LOGGER.info("Finding post with id - {}", id);

        final Optional<Post> optionalPost = postRepository.findById(id);

        LOGGER.info("Successfully found post with id - {}, result - {}", id, optionalPost);
        return optionalPost;
    }

    @Override
    public void deleteById(Long id) {
        Assert.notNull(id, "Post id should not be null");
        LOGGER.info("Deleting post with id - {}", id);

        postRepository.deleteById(id);

        LOGGER.info("Successfully deleted post with id - {}", id);
    }
}
