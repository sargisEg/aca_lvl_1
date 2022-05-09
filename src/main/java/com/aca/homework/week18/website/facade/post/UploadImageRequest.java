package com.aca.homework.week18.website.facade.post;

import org.springframework.util.Assert;

import java.util.Objects;

public final class UploadImageRequest {

    private final String blobId;

    public UploadImageRequest(String blobId) {
        Assert.hasText(blobId, "Blob id should not be null or empty");
        this.blobId = blobId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UploadImageRequest{");
        sb.append("blobId='").append(blobId).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UploadImageRequest)) return false;
        UploadImageRequest that = (UploadImageRequest) o;
        return Objects.equals(blobId, that.blobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blobId);
    }

    public String getBlobId() {
        return blobId;
    }
}
