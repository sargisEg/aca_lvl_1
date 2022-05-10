package com.aca.homework.week18.website.facade.post;

import com.aca.homework.week18.website.facade.post.image.ImageDto;
import com.aca.homework.week18.website.facade.user.UserDto;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public final class PostDto {

    private Long postId;
    private UserDto user;
    private String title;
    private String description;

    private List<ImageDto> images;
    private List<String> errors;

    public PostDto(List<String> errors) {
        Assert.notNull(errors, "Errors should not be null");
        this.errors = errors;
    }

    public PostDto(UserDto user, Long postId, String title, String description, List<ImageDto> images) {
        Assert.notNull(postId, "Post id should not be null");
        Assert.notNull(user, "User should not be null");
        Assert.hasText(title, "Title should not be null or empty");
        Assert.hasText(description, "Description should not be null or empty");
        this.postId = postId;
        this.title = title;
        this.description = description;
        this.user = user;
        this.images = images;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PostDto{");
        sb.append("postId=").append(postId);
        sb.append(", user=").append(user);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", images='").append(images).append('\'');
        sb.append(", errors='").append(errors).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostDto)) return false;
        PostDto that = (PostDto) o;
        return Objects.equals(postId, that.postId)
                && Objects.equals(user, that.user)
                && Objects.equals(title, that.title)
                && Objects.equals(description, that.description)
                && Objects.equals(images, that.images)
                && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, user, title, description, images, errors);
    }

    public Long getPostId() {
        return postId;
    }

    public UserDto getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<ImageDto> getImages() {
        return images;
    }

    public void setImages(List<ImageDto> images) {
        this.images = images;
    }

    public List<String> getErrors() {
        return errors;
    }
}
