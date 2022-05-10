package com.aca.homework.week18.website.facade.post;

import com.aca.homework.week18.website.entity.Image;
import com.aca.homework.week18.website.entity.Post;
import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.facade.post.image.ImageDto;
import com.aca.homework.week18.website.facade.post.image.ImageMapper;
import com.aca.homework.week18.website.facade.post.image.UploadPostImageRequestDto;
import com.aca.homework.week18.website.service.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PostFacadeImpl implements PostFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostFacadeImpl.class);

    private final PostService postService;
    private final UserService userService;
    private final ImageService imageService;
    private final ImageMapper imageMapper;
    private final PostMapper postMapper;

    public PostFacadeImpl(PostService postService,
                          UserService userService,
                          ImageService imageService,
                          ImageMapper imageMapper,
                          PostMapper postMapper) {
        this.postService = postService;
        this.userService = userService;
        this.imageService = imageService;
        this.imageMapper = imageMapper;
        this.postMapper = postMapper;
    }

    @Override
    public PostDto create(PostCreateRequestDto dto) {
        Assert.notNull(dto, "Post creation request dto should not be null");
        LOGGER.info("Creating post for provided request - {}", dto);

        final Optional<User> optionalUser = userService.findByUsername(dto.getUsername());

        if (optionalUser.isEmpty()) {
            return new PostDto(List.of("Not found User with username - " + dto.getUsername()));
        }

        final List<String> blobIdsFromDto = dto.getBlobIds();

        if (blobIdsFromDto.size() > 5) {
            return new PostDto(
                    List.of("Cannot post " + blobIdsFromDto.size() + " images․ Maximum amount of images is 5")
            );
        }

        final Post post = postService.create(
                new CreatePostParams(
                        dto.getTitle(),
                        dto.getDescription(),
                        optionalUser.get().getId()
                )
        );

        final List<ImageDto> imageDtos = new LinkedList<>();

        blobIdsFromDto.forEach(blobId -> {
            final ImageDto imageDto = uploadPostImage(
                    new UploadPostImageRequestDto(
                            blobId,
                            post.getId()
                    )
            );
            imageDtos.add(imageDto);
        });

        final PostDto responseDto = postMapper.map(post, imageDtos);

        LOGGER.info(
                "Successfully created post with provided request - {}, response - {}",
                dto,
                responseDto
        );
        return responseDto;
    }

    @Override
    public ImageDto uploadPostImage(UploadPostImageRequestDto dto) {
        Assert.notNull(dto, "Image upload dto should not be null");
        LOGGER.info("Uploading image for provided request - {}", dto);

        final Image image = imageService.create(
                new CreateImageParams(dto.getBlobId(), dto.getPostId())
        );

        final ImageDto responseDto = imageMapper.map(image);

        LOGGER.info("Successfully uploaded image for provided request - {}, response - {}", dto, responseDto);
        return responseDto;
    }

    @Override
    public GetAllUserPostsResponseDto getAllUserPosts(String username) {
        Assert.notNull(username, "Username should not be null");
        LOGGER.info("Getting all user posts for provided request - {}", username);

        final Optional<User> optionalUser = userService.findByUsername(username);

        if (optionalUser.isEmpty()) {
            return new GetAllUserPostsResponseDto(List.of("Not found User with username - " + username ));
        }

        final List<Post> allPostsByUsername = postService.getAllPostsByUserUsername(username);
        final List<PostDto> posts = new LinkedList<>();

        allPostsByUsername.forEach(post -> {
            final List<Image> images = imageService.findByPostId(post.getId());
            final List<ImageDto> imageDtos = new LinkedList<>();
            images.forEach(image -> {
                imageDtos.add(imageMapper.map(image));
            });
            final PostDto postDto = postMapper.map(post, imageDtos);

            posts.add(postDto);
        });

        final GetAllUserPostsResponseDto responseDto = new GetAllUserPostsResponseDto(posts.get(0).getUser(), posts);

        LOGGER.info("Successfully got all user posts for provided request - {}, response - {}", username, responseDto);
        return responseDto;
    }
}
