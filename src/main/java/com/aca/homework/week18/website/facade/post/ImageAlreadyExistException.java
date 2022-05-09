package com.aca.homework.week18.website.facade.post;

public class ImageAlreadyExistException extends RuntimeException {
    public ImageAlreadyExistException(String blobId) {
        super("Image with blob id - " + blobId + "already exist");
    }
}
