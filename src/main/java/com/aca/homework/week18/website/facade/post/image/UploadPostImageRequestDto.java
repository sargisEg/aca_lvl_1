package com.aca.homework.week18.website.facade.post.image;

import org.springframework.util.Assert;

import java.util.Objects;

public final class UploadPostImageRequestDto {

    private final String blobId;
    private final Long postId;

    public UploadPostImageRequestDto(String blobId, Long postId) {
        Assert.hasText(blobId, "Blob id should not be null or empty");
        Assert.notNull(blobId, "Post id should not be null");
        this.blobId = blobId;
        this.postId = postId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UploadImageRequest{");
        sb.append("blobId='").append(blobId).append('\'');
        sb.append("postId='").append(postId).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UploadPostImageRequestDto)) return false;
        UploadPostImageRequestDto that = (UploadPostImageRequestDto) o;
        return Objects.equals(blobId, that.blobId)
                && Objects.equals(postId, that.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blobId, postId);
    }

    public String getBlobId() {
        return blobId;
    }

    public Long getPostId() {
        return postId;
    }
}
