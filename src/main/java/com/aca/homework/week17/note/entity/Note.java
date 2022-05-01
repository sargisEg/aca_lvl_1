package com.aca.homework.week17.note.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "NOTES")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_NOTES_USER_ID_ID"),
            nullable = false
    )
    private User user;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    public Note() {
    }

    public Note(String text, User user, LocalDate creationDate) {
        this.text = text;
        this.user = user;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Note{");
        sb.append("id=").append(id);
        sb.append(", text='").append(text).append('\'');
        sb.append(", user=").append(user);
        sb.append(", creationDate=").append(creationDate);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id) && Objects.equals(text, note.text) && Objects.equals(user, note.user) && Objects.equals(creationDate, note.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, user, creationDate);
    }
}
