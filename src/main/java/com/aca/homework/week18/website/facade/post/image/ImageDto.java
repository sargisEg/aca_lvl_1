package com.aca.homework.week18.website.facade.post.image;

import org.springframework.util.Assert;

import java.util.Objects;

public final class ImageDto {

    private final Long id;
    private final String blobId;
    private final Long postId;

    public ImageDto(Long id, String blobId, Long postId) {
        Assert.notNull(id, "Id should not be null");
        Assert.notNull(postId, "Post id should not be null");
        Assert.hasText(blobId, "Blob id should not be null or empty");
        this.id = id;
        this.blobId = blobId;
        this.postId = postId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ImageDto{");
        sb.append("id=").append(id);
        sb.append(", blobId='").append(blobId).append('\'');
        sb.append(", postId='").append(postId).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImageDto)) return false;
        ImageDto that = (ImageDto) o;
        return Objects.equals(id, that.id) && Objects.equals(blobId, that.blobId) && Objects.equals(postId, that.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, blobId, postId);
    }

    public Long getId() {
        return id;
    }

    public String getBlobId() {
        return blobId;
    }

    public Long getPostId() {
        return postId;
    }
}
