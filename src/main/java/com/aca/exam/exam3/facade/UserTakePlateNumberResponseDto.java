package com.aca.exam.exam3.facade;

import java.util.Objects;

public final class UserTakePlateNumberResponseDto {

    private final String plateNumber;

    public UserTakePlateNumberResponseDto(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserTakePlateNumberResponseDto{");
        sb.append("plateNumber='").append(plateNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserTakePlateNumberResponseDto)) return false;
        UserTakePlateNumberResponseDto that = (UserTakePlateNumberResponseDto) o;
        return Objects.equals(plateNumber, that.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber);
    }
}
