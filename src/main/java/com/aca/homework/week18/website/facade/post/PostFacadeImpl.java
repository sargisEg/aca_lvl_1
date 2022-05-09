package com.aca.homework.week18.website.facade.post;

import com.aca.homework.week18.website.entity.Image;
import com.aca.homework.week18.website.entity.Post;
import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.service.core.*;
import com.aca.homework.week18.website.service.impl.UserNotFoundException;
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

    public PostFacadeImpl(PostService postService, UserService userService, ImageService imageService) {
        this.postService = postService;
        this.userService = userService;
        this.imageService = imageService;
    }

    @Override
    public PostCreateResponseDto create(PostCreateRequestDto dto) {
        Assert.notNull(dto, "Post creation request dto should not be null");
        LOGGER.info("Creating post for provided request - {}", dto);

        final User user = userService.findByUsername(dto.getUsername())
                .orElseThrow(() -> {
                    throw new UserNotFoundException(dto.getUsername());
                });

        final List<Image> images = dto.getImages();
        final List<Long> imagesId = new LinkedList<>();

        images.forEach(image -> {
            final Optional<Image> optionalImage = imageService.findByBlobId(image.getBlobId());

            if (optionalImage.isEmpty()) {
                UploadImageResponseDto responseDto = uploadImage(new UploadImageRequest(image.getBlobId()));
                imagesId.add(responseDto.getId());
            } else {
                imagesId.add(optionalImage.get().getId());
            }
        });


        final Post post = postService.create(
                new CreatePostParams(
                        dto.getTitle(),
                        dto.getDescription(),
                        user.getId(),
                        imagesId
                )
        );

        final PostCreateResponseDto responseDto = new PostCreateResponseDto(
                post.getUser(),
                post.getId(),
                post.getTitle(),
                post.getDescription(),
                post.getImages()
        );

        LOGGER.info(
                "Successfully created post with provided request - {}, response - {}",
                dto,
                responseDto
        );
        return responseDto;
    }

    @Override
    public UploadImageResponseDto uploadImage(UploadImageRequest dto) {
        Assert.notNull(dto, "Image upload dto should not be null");
        LOGGER.info("Uploading image for provided request - {}", dto);

        final Optional<Image> optionalImage = imageService.findByBlobId(dto.getBlobId());

        if (optionalImage.isPresent()) {
            throw new ImageAlreadyExistException(dto.getBlobId());
        }

        final Image image = imageService.create(
                new CreateImageParams(dto.getBlobId())
        );

        final UploadImageResponseDto responseDto = new UploadImageResponseDto(image.getId(), image.getBlobId());

        LOGGER.info("Successfully uploaded image for provided request - {}, response - {}", dto, responseDto);
        return responseDto;
    }

    @Override
    public GetAllUserPostsResponseDto getAllUserPosts(GetAllUserPostsRequestDto dto) {
        Assert.notNull(dto, "Get all user posts request dto should not be null");
        LOGGER.info("Getting all user posts for provided request - {}", dto);

        final User user = userService.findByUsername(dto.getUsername())
                .orElseThrow(() -> {
                    throw new UserNotFoundException(dto.getUsername());
                });

        final List<Post> allPostsByUsername = postService.getAllPostsByUserUsername(dto.getUsername());

        final GetAllUserPostsResponseDto responseDto = new GetAllUserPostsResponseDto(
                user,
                allPostsByUsername
        );

        LOGGER.info("Successfully got all user posts for provided request - {}, response - {}", dto, responseDto);
        return responseDto;
    }
}
