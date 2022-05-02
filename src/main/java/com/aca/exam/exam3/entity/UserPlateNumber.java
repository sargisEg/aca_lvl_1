package com.aca.exam.exam3.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER_PLATE_NUMBER")
public class UserPlateNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_USER_PLATE_NUMBER_USER_ID"),
            nullable = false
    )
    private User user;

    @OneToOne
    @JoinColumn(
            name = "number_plate_id",
            foreignKey = @ForeignKey(name = "FK_USER_PLATE_NUMBER_NUMBER_PLATE_ID"),
            nullable = false
    )
    private NumberPlate numberPlate;

    public UserPlateNumber() {
    }

    public UserPlateNumber(User user, NumberPlate numberPlate) {
        this.user = user;
        this.numberPlate = numberPlate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public NumberPlate getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(NumberPlate numberPlate) {
        this.numberPlate = numberPlate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserPlateNumber{");
        sb.append("id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", numberPlate=").append(numberPlate);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPlateNumber)) return false;
        UserPlateNumber that = (UserPlateNumber) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(numberPlate, that.numberPlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, numberPlate);
    }
}
