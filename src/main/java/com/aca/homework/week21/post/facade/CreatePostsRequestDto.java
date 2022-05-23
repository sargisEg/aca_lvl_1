package com.aca.homework.week21.post.facade;

import org.springframework.util.Assert;

import java.util.Objects;

public final class CreatePostsRequestDto {

    private String name;

    private Long postCount;

    public CreatePostsRequestDto() {
    }

    public CreatePostsRequestDto(String name, Long postCount) {
        Assert.hasText(name, "Create posts request dto name should not be null");
        Assert.notNull(postCount, "Create posts request dto post count should not be null");
        this.name = name;
        this.postCount = postCount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreatePostsRequestDto{");
        sb.append("name='").append(name).append('\'');
        sb.append(", postCount=").append(postCount);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreatePostsRequestDto)) return false;
        CreatePostsRequestDto that = (CreatePostsRequestDto) o;
        return Objects.equals(name, that.name) && Objects.equals(postCount, that.postCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, postCount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPostCount() {
        return postCount;
    }

    public void setPostCount(Long postCount) {
        this.postCount = postCount;
    }
}
