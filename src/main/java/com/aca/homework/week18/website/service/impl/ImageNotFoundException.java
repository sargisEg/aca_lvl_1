package com.aca.homework.week18.website.service.impl;

public class ImageNotFoundException extends RuntimeException {
    public ImageNotFoundException(Long imageId) {
        super("Not found image with id - " + imageId);
    }
}
