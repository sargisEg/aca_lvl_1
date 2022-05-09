package com.aca.homework.week18.website.facade.post;

import org.springframework.util.Assert;

import java.util.Objects;

public final class UploadImageResponseDto {

    private final Long id;
    private final String blobId;

    public UploadImageResponseDto(Long id, String blobId) {
        Assert.notNull(id, "Id should not be null");
        Assert.hasText(blobId, "Blob id should not be null or empty");
        this.id = id;
        this.blobId = blobId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UploadImageResponseDto{");
        sb.append("id=").append(id);
        sb.append(", blobId='").append(blobId).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UploadImageResponseDto)) return false;
        UploadImageResponseDto that = (UploadImageResponseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(blobId, that.blobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, blobId);
    }

    public Long getId() {
        return id;
    }

    public String getBlobId() {
        return blobId;
    }
}
