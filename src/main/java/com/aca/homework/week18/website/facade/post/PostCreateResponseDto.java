package com.aca.homework.week18.website.facade.post;

import com.aca.homework.week18.website.entity.Image;
import com.aca.homework.week18.website.entity.User;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public final class PostCreateResponseDto {

    private final Long postId;
    private final User user;
    private final String title;
    private final String description;
    private final List<Image> images;

    public PostCreateResponseDto( User user, Long postId, String title, String description, List<Image> images) {
        Assert.notNull(postId, "Post id should not be null");
        Assert.notNull(user, "User should not be null");
        Assert.hasText(title, "Title should not be null or empty");
        Assert.hasText(description, "Description should not be null or empty");
        Assert.notNull(images, "Images should not be null");
        this.postId = postId;
        this.title = title;
        this.description = description;
        this.user = user;
        this.images = images;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PostCreateResponseDto{");
        sb.append("postId=").append(postId);
        sb.append(", user=").append(user);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", images=").append(images);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostCreateResponseDto)) return false;
        PostCreateResponseDto that = (PostCreateResponseDto) o;
        return Objects.equals(postId, that.postId) && Objects.equals(user, that.user) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(images, that.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, user, title, description, images);
    }

    public Long getPostId() {
        return postId;
    }

    public User getUser() {
        return user;
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
}
