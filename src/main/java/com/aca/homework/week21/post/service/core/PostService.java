package com.aca.homework.week21.post.service.core;

import com.aca.homework.week21.post.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post create(CreatePostParams params);

    List<Post> findAll();

    Optional<Post> findById(Long id);

    void deleteById(Long id);
}
