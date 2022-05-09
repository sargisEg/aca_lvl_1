package com.aca.homework.week18.website.facade.post;

public interface PostFacade {

    PostCreateResponseDto create(PostCreateRequestDto dto);

    UploadImageResponseDto uploadImage(UploadImageRequest dto);

    GetAllUserPostsResponseDto getAllUserPosts(GetAllUserPostsRequestDto dto);
}
