package com.aca.homework.week17.note.facade.note;

import java.time.LocalDate;

public class NoteCreationResponseDto {

    private final String username;

    private final String text;

    private final LocalDate creationDate;

    public NoteCreationResponseDto(String username, String text, LocalDate creationDate) {
        this.username = username;
        this.text = text;
        this.creationDate = creationDate;
    }

    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NoteCreationResponseDto{");
        sb.append("username='").append(username).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", creationDate=").append(creationDate);
        sb.append('}');
        return sb.toString();
    }
}
