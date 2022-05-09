package com.aca.homework.week18.website.service.core;

public class ImagesCountException extends RuntimeException {
    public ImagesCountException(int size) {
        super("Cannot post " + size + " images․ Maximum amount of images is 5");
    }
}
