package com.aca.exam.exam3.service.core.users.plate.number;

import org.springframework.util.Assert;

import java.util.Objects;

public class CreateUserPlateNumberParams {

    private final Long userId;

    private final Long numberPlateId;

    public CreateUserPlateNumberParams(Long userId, Long numberPlateId) {
        Assert.notNull(userId, "User id should not be null");
        Assert.notNull(numberPlateId, "Plate number id should not be null");
        this.userId = userId;
        this.numberPlateId = numberPlateId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getNumberPlateId() {
        return numberPlateId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateUserPlateNumberParams{");
        sb.append("userId=").append(userId);
        sb.append(", numberPlateId=").append(numberPlateId);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateUserPlateNumberParams)) return false;
        CreateUserPlateNumberParams that = (CreateUserPlateNumberParams) o;
        return Objects.equals(userId, that.userId) && Objects.equals(numberPlateId, that.numberPlateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, numberPlateId);
    }
}
