package com.aca.homework.week21.post.service.core;

import com.aca.homework.week21.post.repository.PostRepository;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Objects;

public class CreatePostParams {

    private final LocalDateTime creationDate;
    private final String context;
    private final String creatorName;

    public CreatePostParams(LocalDateTime creationDate, String context, String creatorName) {
        Assert.notNull(creationDate, "Creation date should not be null");
        Assert.hasText(context, "Context date should not be null or empty");
        Assert.hasText(creatorName, "Creator name should not be null or empty");
        this.creationDate = creationDate;
        this.context = context;
        this.creatorName = creatorName;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getContext() {
        return context;
    }

    public String getCreatorName() {
        return creatorName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreatePostParams{");
        sb.append("localDateTime=").append(creationDate);
        sb.append(", context='").append(context).append('\'');
        sb.append(", creatorName='").append(creatorName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreatePostParams)) return false;
        CreatePostParams that = (CreatePostParams) o;
        return Objects.equals(creationDate, that.creationDate) && Objects.equals(context, that.context) && Objects.equals(creatorName, that.creatorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate, context, creatorName);
    }
}
