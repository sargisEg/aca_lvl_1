package com.aca.exam.exam3.facade;

import java.util.Objects;

public final class GetAllUserNumbersRequestDto {

    private final String passportId;

    public GetAllUserNumbersRequestDto(String passportId) {
        this.passportId = passportId;
    }

    public String getPassportId() {
        return passportId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetAllUserNumbersRequestDto{");
        sb.append("passwordId='").append(passportId).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAllUserNumbersRequestDto)) return false;
        GetAllUserNumbersRequestDto that = (GetAllUserNumbersRequestDto) o;
        return Objects.equals(passportId, that.passportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportId);
    }
}
