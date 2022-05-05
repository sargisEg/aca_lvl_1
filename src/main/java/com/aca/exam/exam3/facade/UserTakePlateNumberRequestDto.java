package com.aca.exam.exam3.facade;

import java.util.Objects;

public final class UserTakePlateNumberRequestDto {

    private final String passportId;
    private final String plateNumber;

    public UserTakePlateNumberRequestDto(String passportId, String plateNumber) {
        this.passportId = passportId;
        this.plateNumber = plateNumber;
    }

    public String getPassportId() {
        return passportId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserTakePlateNumberRequestDto{");
        sb.append("password_id=").append(passportId);
        sb.append(", plateNumber='").append(plateNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserTakePlateNumberRequestDto)) return false;
        UserTakePlateNumberRequestDto that = (UserTakePlateNumberRequestDto) o;
        return Objects.equals(passportId, that.passportId) && Objects.equals(plateNumber, that.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportId, plateNumber);
    }
}
