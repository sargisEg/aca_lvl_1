package com.aca.homework.week18.website.service.impl;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(Long postId) {
        super("Not found post with id - " + postId);
    }
}
