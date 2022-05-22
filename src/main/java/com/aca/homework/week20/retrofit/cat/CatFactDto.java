package com.aca.homework.week20.retrofit.cat;

import java.util.Objects;

public class CatFactDto {

    private String fact;

    private Long length;

    public CatFactDto() {
    }

    public CatFactDto(String fact, Long length) {
        this.fact = fact;
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CatFactDto)) return false;
        CatFactDto that = (CatFactDto) o;
        return Objects.equals(fact, that.fact) && Objects.equals(length, that.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fact, length);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CatFactDto{");
        sb.append("fact='").append(fact).append('\'');
        sb.append(", length=").append(length);
        sb.append('}');
        return sb.toString();
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }
}
