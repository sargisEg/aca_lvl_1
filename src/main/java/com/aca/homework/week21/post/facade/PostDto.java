package com.aca.homework.week21.post.facade;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public final class PostDto {

    private Long id;
    private LocalDateTime creationDate;
    private String context;
    private String name;

    private List<String> errors;

    public PostDto() {
    }

    public PostDto(List<String> errors) {
        this.errors = errors;
    }

    public PostDto(Long id, LocalDateTime creationDate, String context, String name) {
        this.id = id;
        this.creationDate = creationDate;
        this.context = context;
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PostDto{");
        sb.append("id=").append(id);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", context='").append(context).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", errors='").append(errors).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostDto)) return false;
        PostDto postDto = (PostDto) o;
        return Objects.equals(id, postDto.id) &&
                Objects.equals(creationDate, postDto.creationDate) &&
                Objects.equals(context, postDto.context) &&
                Objects.equals(name, postDto.name) &&
                Objects.equals(errors, postDto.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, context, name, errors);
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
