package com.aca.homework.week18.website.facade.post;

import com.aca.homework.week18.website.entity.Post;
import com.aca.homework.week18.website.entity.User;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public final class GetAllUserPostsResponseDto {

    private final User user;
    private final List<Post> posts;

    public GetAllUserPostsResponseDto(User user, List<Post> posts) {
        Assert.notNull(user, "User should not be null");
        Assert.notNull(posts, "Posts should not be null");
        this.user = user;
        this.posts = posts;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetAllUserPostsResponseDto{");
        sb.append("user=").append(user);
        sb.append(", posts=").append(posts);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAllUserPostsResponseDto)) return false;
        GetAllUserPostsResponseDto that = (GetAllUserPostsResponseDto) o;
        return Objects.equals(user, that.user) && Objects.equals(posts, that.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, posts);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public User getUser() {
        return user;
    }
}
