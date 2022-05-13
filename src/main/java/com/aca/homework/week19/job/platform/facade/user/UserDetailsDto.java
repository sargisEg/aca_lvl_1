package com.aca.homework.week19.job.platform.facade.user;

import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public final class UserDetailsDto {

    private Long id;
    private String username;
    private String name;
    private boolean isOpenForOffers;

    private List<String> errors;

    public UserDetailsDto(List<String> errors) {
        Assert.notNull(
                errors,
                "Class - UserDetailsDto, " +
                        "method - UserDetailsDto(List<String> errors) " +
                        "errors should not be null"
        );
        this.errors = errors;
    }

    public UserDetailsDto(Long id, String username, String name, boolean isOpenForOffers) {
        Assert.notNull(
                id,
                "Class - UserDetailsDto, " +
                        "method - UserDetailsDto(Long id, String username, String name, boolean isOpenForOffers) " +
                        "id should not be null"
        );
        Assert.hasText(
                username,
                "Class - UserDetailsDto, " +
                        "method - UserDetailsDto(Long id, String username, String name, boolean isOpenForOffers) " +
                        "username should not be null or empty"
        );
        Assert.hasText(
                name,
                "Class - UserDetailsDto, " +
                        "method - UserDetailsDto(Long id, String username, String name, boolean isOpenForOffers) " +
                        "name should not be null or empty"
        );
        this.id = id;
        this.username = username;
        this.name = name;
        this.isOpenForOffers = isOpenForOffers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDetailsDto{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", isOpenForOffers=").append(isOpenForOffers);
        sb.append(", errors=").append(errors);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDetailsDto)) return false;
        UserDetailsDto that = (UserDetailsDto) o;
        return isOpenForOffers == that.isOpenForOffers && Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(name, that.name) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name, isOpenForOffers, errors);
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpenForOffers() {
        return isOpenForOffers;
    }

    public void setOpenForOffers(boolean openForOffers) {
        isOpenForOffers = openForOffers;
    }
}
