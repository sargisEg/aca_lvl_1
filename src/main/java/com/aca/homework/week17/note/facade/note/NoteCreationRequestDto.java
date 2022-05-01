package com.aca.homework.week17.note.facade.note;

import org.springframework.util.Assert;

import java.util.Objects;

public final class NoteCreationRequestDto {

    private final String username;

    private final String text;

    public NoteCreationRequestDto(String username, String text) {
        Assert.hasText(username, "Username should not be null or empty");
        Assert.hasText(text, "Text should not be null or empty");
        this.username = username;
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NoteCreationRequestDto{");
        sb.append("username='").append(username).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoteCreationRequestDto)) return false;
        NoteCreationRequestDto that = (NoteCreationRequestDto) o;
        return Objects.equals(username, that.username) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, text);
    }
}
