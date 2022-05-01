package com.aca.homework.week17.note.service.core;

import org.springframework.util.Assert;

import java.time.LocalDate;

public class CreateNoteParams {

    private final String text;

    private final Long userId;

    private final LocalDate creationDate;

    public CreateNoteParams(String text, Long userId, LocalDate creationDate) {
        Assert.hasText(text, "Text should not be null or empty");
        Assert.notNull(userId, "User id should not be null");
        Assert.notNull(creationDate, "Creation date should not be null");
        this.text = text;
        this.userId = userId;
        this.creationDate = creationDate;
    }

    public String getText() {
        return text;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateNoteParams{");
        sb.append("text='").append(text).append('\'');
        sb.append(", user_id=").append(userId);
        sb.append(", creationDate=").append(creationDate);
        sb.append('}');
        return sb.toString();
    }
}
