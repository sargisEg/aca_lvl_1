package com.aca.homework.week18.website.service.core;

import org.springframework.util.Assert;

import java.util.Objects;

public class CreateImageParams {

    private final String blobId;

    public CreateImageParams(String blobId) {
        Assert.hasText(blobId, "Image blob id should not be null or empty");
        this.blobId = blobId;
    }

    public String getBlobId() {
        return blobId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateImageParams{");
        sb.append("blobId='").append(blobId).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateImageParams)) return false;
        CreateImageParams that = (CreateImageParams) o;
        return Objects.equals(blobId, that.blobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blobId);
    }
}
