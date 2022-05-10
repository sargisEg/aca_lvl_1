package com.aca.homework.week18.website.facade.post;

import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.facade.user.UserDto;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public final class GetAllUserPostsResponseDto {

    private UserDto user;
    private List<PostDto> posts;

    private List<String> errors;

    public GetAllUserPostsResponseDto(List<String> errors) {
        Assert.notNull(errors, "Errors should not be null");
        this.errors = errors;
    }

    public GetAllUserPostsResponseDto(UserDto user, List<PostDto> posts) {
        Assert.notNull(user, "User should not be null");
        Assert.notNull(posts, "Posts should not be null");
        this.posts = posts;
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetAllUserPostsResponseDto{");
        sb.append(", user=").append(user);
        sb.append(", posts=").append(posts);
        sb.append(", errors=").append(errors);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAllUserPostsResponseDto)) return false;
        GetAllUserPostsResponseDto that = (GetAllUserPostsResponseDto) o;
        return Objects.equals(posts, that.posts) && Objects.equals(user, that.user) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posts, user, errors);
    }

    public List<PostDto> getPosts() {
        return posts;
    }

    public UserDto getUser() {
        return user;
    }

    public List<String> getErrors() {
        return errors;
    }
}
