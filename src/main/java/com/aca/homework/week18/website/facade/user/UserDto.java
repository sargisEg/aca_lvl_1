package com.aca.homework.week18.website.facade.user;

import java.util.List;
import java.util.Objects;

public class UserDto {

    private Long id;
    private String username;
    private String firstName;
    private String secondName;

    private List<String> errors;

    public UserDto(List<String> errors) {
        this.errors = errors;
    }

    public UserDto(Long id, String username, String firstName, String secondName) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDto{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append(", errors='").append(errors).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(errors, userDto.errors)
                && Objects.equals(id, userDto.id)
                && Objects.equals(username, userDto.username)
                && Objects.equals(firstName, userDto.firstName)
                && Objects.equals(secondName, userDto.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstName, secondName);
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Long getId() {
        return id;
    }

    public List<String> getErrors() {
        return errors;
    }
}
