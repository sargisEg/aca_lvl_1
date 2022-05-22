package com.aca.homework.week21.post.facade;

import com.aca.homework.week21.post.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public PostDto map(Post post) {
        return new PostDto(
                post.getId(),
                post.getCreatedAt(),
                post.getContent(),
                post.getCreatorName()
        );
    }
}
