package com.aca.homework.week19.job.platform.service.core.user;

import org.springframework.util.Assert;

import java.util.Objects;

public class UpdateUserParams {

    private final Long id;
    private final String username;
    private final String name;
    private final boolean isOpenForOffers;

    public UpdateUserParams(Long id, String username, String name, boolean isOpenForOffers) {
        Assert.notNull(
                id,
                "Class - UpdateUserParams, method - UpdateUserParams(Long id, String username, String name, boolean isOpenForOffers) " +
                        "id should not be null"
        );        Assert.hasText(
                username,
                "Class - UpdateUserParams, method - UpdateUserParams(Long id, String username, String name, boolean isOpenForOffers) " +
                        "username should not be null or empty"
        );
        Assert.hasText(
                name,
                "Class - UpdateUserParams, method - UpdateUserParams(Long id, String username, String name, boolean isOpenForOffers) " +
                        "name should not be null or empty");
        this.id = id;
        this.username = username;
        this.name = name;
        this.isOpenForOffers = isOpenForOffers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UpdateUserParams{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", isOpenForOffers=").append(isOpenForOffers);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateUserParams)) return false;
        UpdateUserParams that = (UpdateUserParams) o;
        return isOpenForOffers == that.isOpenForOffers && Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name, isOpenForOffers);
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public boolean isOpenForOffers() {
        return isOpenForOffers;
    }
}
