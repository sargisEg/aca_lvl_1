package com.aca.homework.week18.website.facade.post;

import com.aca.homework.week18.website.facade.post.image.ImageDto;
import com.aca.homework.week18.website.facade.post.image.UploadPostImageRequestDto;

public interface PostFacade {

    PostDto create(PostCreateRequestDto dto);

    ImageDto uploadPostImage(UploadPostImageRequestDto dto);

    GetAllUserPostsResponseDto getAllUserPosts(String username);
}
