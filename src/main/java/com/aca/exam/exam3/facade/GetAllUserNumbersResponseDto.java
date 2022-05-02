package com.aca.exam.exam3.facade;

import com.aca.exam.exam3.entity.NumberPlate;

import java.util.List;
import java.util.Objects;

public final class GetAllUserNumbersResponseDto {

    private final List<NumberPlate> plateNumbers;

    public GetAllUserNumbersResponseDto(List<NumberPlate> plateNumbers) {
        this.plateNumbers = plateNumbers;
    }

    public List<NumberPlate> getPlateNumbers() {
        return plateNumbers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetAllUserNumbersResponseDto{");
        sb.append("plateNumbers=").append(plateNumbers);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAllUserNumbersResponseDto)) return false;
        GetAllUserNumbersResponseDto that = (GetAllUserNumbersResponseDto) o;
        return Objects.equals(plateNumbers, that.plateNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumbers);
    }
}
