package com.aca.homework.week21.post.facade;

import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.service.core.CreatePostParams;
import com.aca.homework.week21.post.service.core.LocalDateTimeService;
import com.aca.homework.week21.post.service.core.PostService;
import com.aca.homework.week21.post.service.core.RandomFactService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostFacadeImplTest {

    private PostFacade testSubject;

    @Mock
    private PostService postService;

    @Mock
    private RandomFactService randomFactService;

    @Mock
    private PostMapper postMapper;

    @Mock
    private LocalDateTimeService localDateTimeService;

    @BeforeEach
    public void init() {
        testSubject = new PostFacadeImpl(
                postService,
                randomFactService,
                postMapper,
                localDateTimeService,
                "prefix_");
    }

    @Test
    public void testCreatePostWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.createPost(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testGetPostByIdWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.getPostById(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testDeletePostByIdWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.deletePostById(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCreatePost() {
        final Post post = new Post(
                LocalDateTime.of(1111, 11, 11, 11, 11),
                "context",
                "name"
        );
        post.setId(1L);
        when(postService.create(new CreatePostParams(
                LocalDateTime.of(1111, 11, 11, 11, 11),
                "context",
                "name"
        ))).thenReturn(post);

        when(randomFactService.getRandomFact())
                .thenReturn("context");
        when(localDateTimeService.getNow())
                .thenReturn(LocalDateTime.of(1111, 11, 11, 11, 11));

        final PostDto postDto = new PostDto(
                1L,
                LocalDateTime.of(1111, 11, 11, 11, 11),
                "context",
                "name"
        );
        when(postMapper.map(post))
                .thenReturn(postDto);

        Assertions.assertThat(testSubject.createPost(new CreatePostRequestDto("name")))
                .isEqualTo(postDto);

        verify(postService).create(new CreatePostParams(
                LocalDateTime.of(1111, 11, 11, 11, 11),
                "context",
                "name"
        ));
        verify(randomFactService).getRandomFact();
        verify(postMapper).map(post);
        verifyNoMoreInteractions(postService, randomFactService, postMapper);
    }

    @Test
    public void testGetPostByIdWhenPostNotFound() {
        when(postService.findById(1L))
                .thenReturn(Optional.empty());

        Assertions.assertThat(testSubject.getPostById(1L))
                .isEqualTo(new PostDto(List.of("Not found post with id - 1")));

        verify(postService).findById(1L);
        verifyNoMoreInteractions(randomFactService, postService, postMapper);
    }

    @Test
    public void testGetPostById() {
        final Post post = new Post();
        post.setId(1L);
        when(postService.findById(1L))
                .thenReturn(Optional.of(post));

        when(postMapper.map(post))
                .thenReturn(new PostDto(List.of("test")));

        Assertions.assertThat(testSubject.getPostById(1L))
                .isEqualTo(new PostDto(List.of("test")));

        verify(postService).findById(1L);
        verify(postMapper).map(post);
        verifyNoMoreInteractions(randomFactService, postService, postMapper);
    }

    @Test
    public void testDeletePostById() {
        testSubject.deletePostById(1L);

        verify(postService).deleteById(1L);
        verifyNoMoreInteractions(postMapper, postService, randomFactService);
    }

    @Test
    public void testGetAllPosts() {
        when(postService.findAll())
                .thenReturn(List.of(new Post()));
        when(postMapper.map(new Post()))
                .thenReturn(new PostDto(List.of("test")));

        Assertions.assertThat(testSubject.getAllPosts())
                .isEqualTo(List.of(new PostDto(List.of("test"))));

        verify(postService).findAll();
        verify(postMapper).map(new Post());
        verifyNoMoreInteractions(postService, postMapper, randomFactService);
    }

    @Test
    public void testCreatePosts() {
        final Post post = new Post(
                LocalDateTime.of(1111, 11, 11, 11, 11),
                "prefix_context",
                "name"
        );
        post.setId(1L);
        when(postService.create(new CreatePostParams(
                LocalDateTime.of(1111, 11, 11, 11, 11),
                "prefix_context",
                "name"
        ))).thenReturn(post);

        when(randomFactService.getRandomFact())
                .thenReturn("context");
        when(localDateTimeService.getNow())
                .thenReturn(LocalDateTime.of(1111, 11, 11, 11, 11));

        final PostDto postDto = new PostDto(
                1L,
                LocalDateTime.of(1111, 11, 11, 11, 11),
                "prefix_context",
                "name"
        );
        when(postMapper.map(post))
                .thenReturn(postDto);

        Assertions.assertThat(testSubject.createPosts(
                new CreatePostsRequestDto(
                        "name",
                        1L
                )
        )).isEqualTo(List.of(postDto));

        verify(postService).create(new CreatePostParams(
                LocalDateTime.of(1111, 11, 11, 11, 11),
                "prefix_context",
                "name"
        ));
        verify(randomFactService).getRandomFact();
        verify(postMapper).map(post);
        verifyNoMoreInteractions(postService, randomFactService, postMapper);

    }
}