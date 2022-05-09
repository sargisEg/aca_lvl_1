package com.aca.homework.week18.website.facade.post;

import com.aca.homework.week18.website.entity.Image;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public final class PostCreateRequestDto {

    private final String username;
    private final String title;
    private final String description;
    private final List<Image> images;

    public PostCreateRequestDto(String username, String title, String description, List<Image> images) {
        Assert.hasText(username, "Username should not be null or empty");
        Assert.hasText(title, "Title should not be null or empty");
        Assert.hasText(description, "Description should not be null or empty");
        Assert.notNull(images, "Images should not be null");
        this.username = username;
        this.title = title;
        this.description = description;
        this.images = images;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Image> getImages() {
        return images;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PostCreateRequestDto{");
        sb.append("username='").append(username).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", images=").append(images);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostCreateRequestDto)) return false;
        PostCreateRequestDto that = (PostCreateRequestDto) o;
        return Objects.equals(username, that.username) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(images, that.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, title, description, images);
    }
}
