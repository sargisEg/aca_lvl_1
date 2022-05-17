package com.aca.homework.week19.job.platform.service.core.organization;

import org.springframework.util.Assert;

import java.util.Objects;

public class CreateEmployerParams {

    private final Long userId;
    private final Long organizationId;

    public CreateEmployerParams(Long userId, Long organizationId) {
        Assert.notNull(
                userId,
                "Class - CreateEmployerParams, method - CreateEmployerParams(Long userId, Long organizationId) " +
                        "userId should not be null"
        );
        Assert.notNull(
                organizationId,
                "Class - CreateEmployerParams, method - CreateEmployerParams(Long userId, Long organizationId) " +
                        "organizationId should not be null"
        );
        this.userId = userId;
        this.organizationId = organizationId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateEmployerParams{");
        sb.append("userId=").append(userId);
        sb.append(", organizationId=").append(organizationId);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateEmployerParams)) return false;
        CreateEmployerParams that = (CreateEmployerParams) o;
        return Objects.equals(userId, that.userId) && Objects.equals(organizationId, that.organizationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, organizationId);
    }

    public Long getUserId() {
        return userId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }
}
