package com.aca.homework.week19.job.platform.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "USER_ID_SEQUENCE"
    )
    @SequenceGenerator(name = "USER_ID_SEQUENCE")
    private Long id;

    @Column(
            name = "username",
            nullable = false,
            unique = true,
            length = 15
    )
    private String username;

    @Column(
            name = "name",
            nullable = false,
            length = 25
    )
    private String name;

    @Column(
            name = "is_open_for_offers",
            nullable = false
    )
    private boolean isOpenForOffers;

    public User() {
    }

    public User(String username, String name, boolean isOpenForOffers) {
        this.username = username;
        this.name = name;
        this.isOpenForOffers = isOpenForOffers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", isOpenForOffers='").append(isOpenForOffers).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(name, user.name) && Objects.equals(isOpenForOffers, user.isOpenForOffers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name, isOpenForOffers);
    }

    public boolean isOpenForOffers() {
        return isOpenForOffers;
    }

    public void setOpenForOffers(boolean openForOffers) {
        isOpenForOffers = openForOffers;
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
}
