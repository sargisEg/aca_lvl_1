package com.aca.homework.week18.website.facade.post;

import java.util.Objects;

public final class GetAllUserPostsRequestDto {

    private final String username;

    public GetAllUserPostsRequestDto(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetAllUserPostsRequest{");
        sb.append("username='").append(username).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAllUserPostsRequestDto)) return false;
        GetAllUserPostsRequestDto that = (GetAllUserPostsRequestDto) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    public String getUsername() {
        return username;
    }
}
