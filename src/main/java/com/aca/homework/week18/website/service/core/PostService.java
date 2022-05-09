package com.aca.homework.week18.website.service.core;

import com.aca.homework.week18.website.entity.Post;
import com.aca.homework.week18.website.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    Post create(CreatePostParams params);

    List<Post> getAllPostsByUserUsername(String username);
}
