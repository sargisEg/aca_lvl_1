package com.aca.homework.week18.website.facade;

import com.aca.homework.week18.website.entity.Image;
import com.aca.homework.week18.website.entity.Post;
import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.facade.post.*;
import com.aca.homework.week18.website.facade.post.image.ImageDto;
import com.aca.homework.week18.website.facade.post.image.ImageMapper;
import com.aca.homework.week18.website.facade.post.image.ImageMapperImpl;
import com.aca.homework.week18.website.facade.post.image.UploadPostImageRequestDto;
import com.aca.homework.week18.website.facade.user.UserDto;
import com.aca.homework.week18.website.facade.user.UserMapper;
import com.aca.homework.week18.website.facade.user.UserMapperImpl;
import com.aca.homework.week18.website.service.core.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class PostFacadeImplTest {

    private PostFacade testSubject;

    @Mock
    private PostService postService;

    @Mock
    private UserService userService;

    @Mock
    private ImageService imageService;

    private ImageMapper imageMapper;

    private PostMapper postMapper;

    private UserMapper userMapper;

    @BeforeEach
    public void init() {
        imageMapper = new ImageMapperImpl();
        userMapper = new UserMapperImpl();
        postMapper = new PostMapperImpl(userMapper);
        testSubject = new PostFacadeImpl(
                postService,
                userService,
                imageService,
                imageMapper,
                postMapper
        );
    }

    @Test
    public void testUploadPostImage() {

        final Post post = new Post();
        post.setId(1L);
        final Image returnImage = new Image("AAA111", post);
        returnImage.setId(2L);
        Mockito.when(
                imageService.create(new CreateImageParams(
                        "AAA111",
                        1L
                ))
        ).thenReturn(returnImage);

        final ImageDto actualResponseDto = testSubject.uploadPostImage(new UploadPostImageRequestDto(
                "AAA111",
                1L
        ));

        final ImageDto expectedResponseDto = new ImageDto(
                2L,
                "AAA111",
                1L
        );

        Assertions.assertThat(actualResponseDto).isEqualTo(expectedResponseDto);

        Mockito.verify(imageService).create(new CreateImageParams(
                "AAA111",
                1L
        ));
        Mockito.verifyNoMoreInteractions(postService, userService, imageService);
    }

    @Test
    public void testCreateWhenUserNotFound() {

        Mockito.when(userService.findByUsername("username")).thenReturn(Optional.empty());

        final PostDto actualResponseDto = testSubject.create(new PostCreateRequestDto(
                "username",
                "title",
                "des",
                List.of("aa1", "bb2")
        ));

        final PostDto expectedResponseDto = new PostDto(List.of("Not found User with username - username"));

        Assertions.assertThat(actualResponseDto).isEqualTo(expectedResponseDto);

        Mockito.verify(userService).findByUsername("username");
        Mockito.verifyNoMoreInteractions(postService, userService, imageService);
    }

    @Test
    public void testCreateWhenImageNumberMoreThen5() {

        final User returnUser = new User(
                "username",
                "first",
                "second"
        );
        returnUser.setId(1L);

        Mockito.when(userService.findByUsername("username")).thenReturn(Optional.of(returnUser));

        final PostDto actualResponseDto = testSubject.create(new PostCreateRequestDto(
                "username",
                "title",
                "des",
                List.of("aa1", "bb2", "cc3", "dd4", "ee5", "ff6")
        ));

        final PostDto expectedResponseDto = new PostDto(List.of("Cannot post 6 images․ Maximum amount of images is 5"));

        Assertions.assertThat(actualResponseDto).isEqualTo(expectedResponseDto);

        Mockito.verify(userService).findByUsername("username");
        Mockito.verifyNoMoreInteractions(postService, userService, imageService);
    }

    @Test
    public void testCreate() {

        final User returnUser = new User("username", "first", "second");
        returnUser.setId(1L);
        Mockito.when(userService.findByUsername("username")).thenReturn(Optional.of(returnUser));

        final Post returnPost = new Post("title", "des", returnUser);
        returnPost.setId(25L);
        Mockito.when(
                postService.create(new CreatePostParams(
                        "title",
                        "des",
                        1L
                ))
        ).thenReturn(returnPost);

        final Image returnImage1 = new Image("aa1", returnPost);
        returnImage1.setId(1L);
        Mockito.when(
                imageService.create(new CreateImageParams("aa1", 25L))
        ).thenReturn(returnImage1);

        final Image returnImage2 = new Image("ab12", returnPost);
        returnImage2.setId(2L);
        Mockito.when(
                imageService.create(new CreateImageParams("ab12", 25L))
        ).thenReturn(returnImage2);

        final PostDto actualResponseDto = testSubject.create(new PostCreateRequestDto(
                "username",
                "title",
                "des",
                List.of("aa1", "ab12")
        ));

        final PostDto expectedResponseDto = new PostDto(
                new UserDto(1L, "username", "first", "second"),
                25L,
                "title",
                "des",
                List.of(
                        new ImageDto(1L, "aa1", 25L),
                        new ImageDto(2L, "ab12", 25L)
                )
        );

        Assertions.assertThat(actualResponseDto).isEqualTo(expectedResponseDto);

        Mockito.verify(userService).findByUsername("username");
        Mockito.verify(postService).create(new CreatePostParams(
                "title",
                "des",
                1L
        ));
        Mockito.verify(imageService).create(new CreateImageParams("aa1", 25L));
        Mockito.verify(imageService).create(new CreateImageParams("ab12", 25L));
        Mockito.verifyNoMoreInteractions(postService, userService, imageService);
    }

    @Test
    public void testGetAllUserPostsWhenUserNotFound() {
        Mockito.when(userService.findByUsername("username")).thenReturn(Optional.empty());

        final GetAllUserPostsResponseDto actualResponseDto = testSubject.getAllUserPosts("username");

        final GetAllUserPostsResponseDto expectedResponseDto = new GetAllUserPostsResponseDto(
                List.of("Not found User with username - username")
        );

        Assertions.assertThat(actualResponseDto).isEqualTo(expectedResponseDto);

        Mockito.verify(userService).findByUsername("username");
        Mockito.verifyNoMoreInteractions(postService, userService, imageService);
    }

    @Test
    public void testGetAllUserPosts() {

        final User returnUser = new User("username", "first", "second");
        returnUser.setId(1L);
        Mockito.when(userService.findByUsername("username")).thenReturn(Optional.of(returnUser));

        final Post post1 = new Post("title1", "des1", returnUser);
        post1.setId(10L);
        final Post post2 = new Post("title2", "des2", returnUser);
        post2.setId(11L);
        List<Post> returnPostsList = List.of(
                post1,
                post2
        );
        Mockito.when(postService.getAllPostsByUserUsername("username")).thenReturn(returnPostsList);

        final Image image1ForPost1 = new Image("a1", post1);
        image1ForPost1.setId(20L);
        final Image image2ForPost1 = new Image("a2", post1);
        image2ForPost1.setId(21L);
        final List<Image> returnImageListForPost1 = List.of(image1ForPost1, image2ForPost1);
        Mockito.when(imageService.findByPostId(10L)).thenReturn(returnImageListForPost1);

        final Image image1ForPost2 = new Image("b1", post2);
        image1ForPost2.setId(22L);
        final Image image2ForPost2 = new Image("b2", post2);
        image2ForPost2.setId(23L);
        final List<Image> returnImageListForPost2 = List.of(image1ForPost2, image2ForPost2);
        Mockito.when(imageService.findByPostId(11L)).thenReturn(returnImageListForPost2);

        final GetAllUserPostsResponseDto actualResponseDto = testSubject.getAllUserPosts("username");

        final GetAllUserPostsResponseDto expectedResponseDto = new GetAllUserPostsResponseDto(
                new UserDto(1L, "username", "first", "second"),
                List.of(
                        new PostDto(
                                new UserDto(1L, "username", "first", "second"),
                                10L,
                                "title1",
                                "des1",
                                List.of(new ImageDto(20L, "a1", 10L), new ImageDto(21L, "a2", 10L))
                        ),
                        new PostDto(
                                new UserDto(1L, "username", "first", "second"),
                                11L,
                                "title2",
                                "des2",
                                List.of(new ImageDto(22L, "b1", 11L), new ImageDto(23L, "b2", 11L))
                        )
                )
        );

        Assertions.assertThat(actualResponseDto).isEqualTo(expectedResponseDto);

        Mockito.verify(userService).findByUsername("username");
        Mockito.verify(postService).getAllPostsByUserUsername("username");
        Mockito.verify(imageService).findByPostId(10L);
        Mockito.verify(imageService).findByPostId(11L);
        Mockito.verifyNoMoreInteractions(postService, userService, imageService);
    }
}