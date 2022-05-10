package com.aca.homework.week18.website.facade.post;

import com.aca.homework.week18.website.entity.Post;
import com.aca.homework.week18.website.facade.post.image.ImageDto;

import java.util.List;

public interface PostMapper {

    PostDto map(Post post, List<ImageDto> images);
}
