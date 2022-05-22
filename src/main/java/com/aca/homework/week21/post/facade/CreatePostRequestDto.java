package com.aca.homework.week21.post.facade;

import org.springframework.util.Assert;

import java.util.Objects;

public final class CreatePostRequestDto {

    private String name;

    public CreatePostRequestDto() {
    }

    public CreatePostRequestDto(String name) {
        Assert.hasText(name, "Create post request dto name should not be null");
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreatePostRequestDto{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreatePostRequestDto)) return false;
        CreatePostRequestDto that = (CreatePostRequestDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
