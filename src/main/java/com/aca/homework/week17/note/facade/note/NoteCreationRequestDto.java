package com.aca.homework.week17.note.facade.note;

public class NoteCreationRequestDto {

    private final String username;

    private final String text;

    public NoteCreationRequestDto(String username, String text) {
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
}
