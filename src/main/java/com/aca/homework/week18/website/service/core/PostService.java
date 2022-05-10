package com.aca.homework.week18.website.service.core;

import com.aca.homework.week18.website.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {

    Post create(CreatePostParams params);

    List<Post> getAllPostsByUserUsername(String username);

    Optional<Post> findById(Long id);
}
