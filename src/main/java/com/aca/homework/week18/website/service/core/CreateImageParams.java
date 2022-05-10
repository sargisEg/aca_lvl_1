package com.aca.homework.week18.website.service.core;

import org.springframework.util.Assert;

import java.util.Objects;

public class CreateImageParams {

    private final String blobId;
    private final Long postId;

    public CreateImageParams(String blobId, Long postId) {
        Assert.hasText(blobId, "Image blob id should not be null or empty");
        Assert.notNull(postId, "Post id should not be null");
        this.postId = postId;
        this.blobId = blobId;
    }

    public String getBlobId() {
        return blobId;
    }

    public Long getPostId() {
        return postId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateImageParams{");
        sb.append("blobId='").append(blobId).append('\'');
        sb.append("postId='").append(postId).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateImageParams)) return false;
        CreateImageParams that = (CreateImageParams) o;
        return Objects.equals(blobId, that.blobId)
                && Objects.equals(postId, that.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blobId, postId);
    }
}
