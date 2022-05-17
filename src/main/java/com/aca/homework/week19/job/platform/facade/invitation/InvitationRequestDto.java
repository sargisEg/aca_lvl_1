package com.aca.homework.week19.job.platform.facade.invitation;

import org.springframework.util.Assert;

import java.util.Objects;

public final class InvitationRequestDto {

    private Long userId;

    private Long organizationId;

    public InvitationRequestDto(Long userId, Long organizationId) {
        Assert.notNull(
                userId,
                "Class - InvitationRequestDto, method - InvitationRequestDto(Long userId, Long organizationId) " +
                        "userId should not be null"
        );
        Assert.notNull(
                organizationId,
                "Class - InvitationRequestDto, method - InvitationRequestDto(Long userId, Long organizationId) " +
                        "organizationId should not be null"
        );
        this.userId = userId;
        this.organizationId = organizationId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InvitationRequestDto{");
        sb.append("userId=").append(userId);
        sb.append(", organizationId=").append(organizationId);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvitationRequestDto)) return false;
        InvitationRequestDto that = (InvitationRequestDto) o;
        return Objects.equals(userId, that.userId) && Objects.equals(organizationId, that.organizationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, organizationId);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
