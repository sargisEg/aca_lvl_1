package com.aca.exam.exam3.facade;

import java.util.Objects;

public final class UserTakePlateNumberResponseDto {

    private final String plateNumber;
    private final String passportId;

    public UserTakePlateNumberResponseDto(String plateNumber, String passportId) {
        this.plateNumber = plateNumber;
        this.passportId = passportId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getPassportId() {
        return passportId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserTakePlateNumberResponseDto{");
        sb.append("plateNumber='").append(plateNumber).append('\'');
        sb.append("passportId='").append(passportId).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserTakePlateNumberResponseDto)) return false;
        UserTakePlateNumberResponseDto that = (UserTakePlateNumberResponseDto) o;
        return Objects.equals(plateNumber, that.plateNumber) && Objects.equals(passportId, that.passportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, passportId);
    }
}
