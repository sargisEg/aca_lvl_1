package com.aca.exam.exam3.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "NUMBER_PLATE")
public class NumberPlate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "plate_number",
            nullable = false,
            unique = true,
            length = 6
    )
    private String plateNumber;

    public NumberPlate() {
    }

    public NumberPlate(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NumberPlate{");
        sb.append("id=").append(id);
        sb.append(", plateNumber='").append(plateNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberPlate)) return false;
        NumberPlate that = (NumberPlate) o;
        return Objects.equals(id, that.id) && Objects.equals(plateNumber, that.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plateNumber);
    }
}
