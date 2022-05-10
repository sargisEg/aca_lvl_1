package com.aca.homework.week18.website.facade.post.image;

import com.aca.homework.week18.website.entity.Image;

public class ImageMapperImpl implements ImageMapper {

    @Override
    public ImageDto map(Image image) {
        return new ImageDto(
                image.getId(),
                image.getBlobId(),
                image.getPost().getId()
        );
    }
}
