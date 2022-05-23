package com.aca.homework.week21.post.service.impl;

import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.repository.PostRepository;
import com.aca.homework.week21.post.service.core.CreatePostParams;
import com.aca.homework.week21.post.service.core.PostService;
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
class PostServiceImplTest {

    private PostService testSubject;

    @Mock
    private PostRepository postRepository;

    @BeforeEach
    public void init() {
        testSubject = new PostServiceImpl(postRepository);
    }

    @Test
    public void testCreateWhenParamsIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.create(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testFindByIdWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.findById(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void testDeleteByIdWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.deleteById(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCreate() {
        final Post post = new Post(
                LocalDateTime.of(1111,11,11,11,11),
                "content",
                "name"
        );
        post.setId(1L);
        when(postRepository.save(new Post(
                LocalDateTime.of(1111,11,11,11,11),
                "content",
                "name"
        ))).thenReturn(post);

        Assertions.assertThat(testSubject.create(new CreatePostParams(
                LocalDateTime.of(1111,11,11,11,11),
                "content",
                "name"
        ))).isEqualTo(post);

        verify(postRepository).save(new Post(
                LocalDateTime.of(1111,11,11,11,11),
                "content",
                "name"
        ));
        verifyNoMoreInteractions(postRepository);
    }

    @Test
    public void testFindAll() {
        when(postRepository.findAll())
                .thenReturn(List.of(new Post()));

        Assertions.assertThat(testSubject.findAll())
                        .isEqualTo(List.of(new Post()));

        verify(postRepository).findAll();
        verifyNoMoreInteractions(postRepository);
    }

    @Test
    public void testFindById() {
        when(postRepository.findById(1L))
                .thenReturn(Optional.of(new Post()));

        Assertions.assertThat(testSubject.findById(1L))
                        .isEqualTo(Optional.of(new Post()));

        verify(postRepository).findById(1L);
        verifyNoMoreInteractions(postRepository);
    }

    @Test
    public void testDeleteById() {

        testSubject.deleteById(1L);

        verify(postRepository).deleteById(1L);
        verifyNoMoreInteractions(postRepository);
    }
}