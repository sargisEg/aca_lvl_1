package com.aca.homework.week21.post.facade;

import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.service.core.CreatePostParams;
import com.aca.homework.week21.post.service.core.LocalDateTimeService;
import com.aca.homework.week21.post.service.core.PostService;
import com.aca.homework.week21.post.service.core.RandomFactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class PostFacadeImpl implements PostFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostFacadeImpl.class);

    private final PostService postService;
    private final RandomFactService randomFactService;
    private final PostMapper postMapper;
    private final LocalDateTimeService localDateTimeService;

    public PostFacadeImpl(PostService postService, RandomFactService randomFactService, PostMapper postMapper, LocalDateTimeService localDateTimeService) {
        this.postService = postService;
        this.randomFactService = randomFactService;
        this.postMapper = postMapper;
        this.localDateTimeService = localDateTimeService;
    }

    @Override
    public PostDto createPost(CreatePostRequestDto dto) {
        Assert.notNull(dto, "Post creation request dto should not be null");
        LOGGER.info("Creating post for provided request - {}", dto);

        final Post post = postService.create(new CreatePostParams(
                localDateTimeService.getNow(),
                randomFactService.getRandomFact(),
                dto.getName()
        ));

        final PostDto postDto = postMapper.map(post);

        LOGGER.info("Successfully created post for provided request - {}, response - {}", dto, postDto);
        return postDto;
    }

    @Override
    public PostDto getPostById(Long id) {
        Assert.notNull(id, "Post id should not be null");
        LOGGER.info("Getting post for provided request - {}", id);

        final Optional<Post> optionalPost = postService.findById(id);

        if (optionalPost.isEmpty()) {
            return new PostDto(List.of("Not found post with id - " + id));
        }

        final Post post = optionalPost.get();

        final PostDto postDto = postMapper.map(post);

        LOGGER.info("Successfully got a post for provided request - {}, response - {}", id, postDto);
        return postDto;
    }

    @Override
    public void deletePostById(Long id) {
        Assert.notNull(id, "Post id should not be null");
        LOGGER.info("Deleting post for provided request - {}", id);

        postService.deleteById(id);

        LOGGER.info("Successfully deleted post for provided request - {}", id);
    }

    @Override
    public List<PostDto> getAllPosts() {
        LOGGER.info("Getting all posts for provided request");

        final List<Post> posts = postService.findAll();
        final List<PostDto> postDtos = new LinkedList<>();

        posts.forEach(post -> postDtos.add(postMapper.map(post)));

        LOGGER.info("Successfully got a post for provided request, response - {}", postDtos);
        return postDtos;
    }
}
