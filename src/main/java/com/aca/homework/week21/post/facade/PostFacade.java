package com.aca.homework.week21.post.facade;

import java.util.List;

public interface PostFacade {

    PostDto createPost(CreatePostRequestDto dto);

    PostDto getPostById(Long id);

    void deletePostById(Long id);

    List<PostDto> getAllPosts();
}