package com.aca.exam.exam3.facade;

import java.util.Objects;

public final class UserTakePlateNumberRequestDto {

    private final Long password_id;
    private final String plateNumber;

    public UserTakePlateNumberRequestDto(Long password_id, String plateNumber) {
        this.password_id = password_id;
        this.plateNumber = plateNumber;
    }

    public Long getPassword_id() {
        return password_id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserTakePlateNumberRequestDto{");
        sb.append("password_id=").append(password_id);
        sb.append(", plateNumber='").append(plateNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserTakePlateNumberRequestDto)) return false;
        UserTakePlateNumberRequestDto that = (UserTakePlateNumberRequestDto) o;
        return Objects.equals(password_id, that.password_id) && Objects.equals(plateNumber, that.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password_id, plateNumber);
    }
}
