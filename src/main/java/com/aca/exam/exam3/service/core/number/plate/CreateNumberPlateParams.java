package com.aca.exam.exam3.service.core.number.plate;

import org.springframework.util.Assert;

import java.util.Objects;

public class CreateNumberPlateParams {

    private final String plateNumber;

    public CreateNumberPlateParams(String plateNumber) {
        Assert.hasText(plateNumber, "Plate number should not be null or empty");
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateNumberPlateParams{");
        sb.append("plateNumber='").append(plateNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateNumberPlateParams)) return false;
        CreateNumberPlateParams that = (CreateNumberPlateParams) o;
        return Objects.equals(plateNumber, that.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber);
    }
}
