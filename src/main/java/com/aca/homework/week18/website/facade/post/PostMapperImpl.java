package com.aca.homework.week18.website.facade.post;

import com.aca.homework.week18.website.entity.Post;
import com.aca.homework.week18.website.facade.post.image.ImageDto;
import com.aca.homework.week18.website.facade.user.UserMapper;

import java.util.List;

public class PostMapperImpl implements PostMapper {

    private final UserMapper userMapper;

    public PostMapperImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public PostDto map(Post post, List<ImageDto> images) {
        return new PostDto(
                userMapper.map(post.getUser()),
                post.getId(),
                post.getTitle(),
                post.getDescription(),
                images
        );
    }
}
