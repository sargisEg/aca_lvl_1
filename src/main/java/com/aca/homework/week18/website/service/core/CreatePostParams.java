package com.aca.homework.week18.website.service.core;

import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public class CreatePostParams {

    private final String title;
    private final String description;
    private final Long userId;
    private final List<Long> imagesId;

    public CreatePostParams(String title, String description, Long userId, List<Long> imagesId) {
        Assert.hasText(title, "Post's title should not be null or empty");
        Assert.hasText(description, "Post's description should not be null or empty");
        Assert.notNull(userId, "Post's user id should not be null");
        Assert.notNull(imagesId, "Post's images should not be null");
        if (imagesId.size() > 5) {
            throw new ImagesCountException(imagesId.size());
        }
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.imagesId = imagesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreatePostParams)) return false;
        CreatePostParams that = (CreatePostParams) o;
        return Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(userId, that.userId) && Objects.equals(imagesId, that.imagesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, userId, imagesId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreatePostParams{");
        sb.append("title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", userId=").append(userId);
        sb.append(", images=").append(imagesId);
        sb.append('}');
        return sb.toString();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getUserId() {
        return userId;
    }

    public List<Long> getImages() {
        return imagesId;
    }
}
