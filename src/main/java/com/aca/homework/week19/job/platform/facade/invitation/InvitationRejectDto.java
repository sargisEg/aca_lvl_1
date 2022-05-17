package com.aca.homework.week19.job.platform.facade.invitation;

import org.springframework.util.Assert;

import java.util.Objects;

public final class InvitationRejectDto {

    private Long userId;
    private Long invitationId;

    public InvitationRejectDto(Long userId, Long invitationId) {
        Assert.notNull(
                userId,
                "Class - InvitationRejectDto, method - InvitationRejectDto(Long userId, Long invitationId) " +
                        "userId should not be null"
        );
        Assert.notNull(
                invitationId,
                "Class - InvitationRejectDto, method - InvitationRejectDto(Long userId, Long invitationId) " +
                        "invitationId should not be null"
        );
        this.userId = userId;
        this.invitationId = invitationId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InvitationRejectDto{");
        sb.append("userId=").append(userId);
        sb.append(", invitationId=").append(invitationId);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvitationRejectDto)) return false;
        InvitationRejectDto that = (InvitationRejectDto) o;
        return Objects.equals(userId, that.userId) && Objects.equals(invitationId, that.invitationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, invitationId);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Long invitationId) {
        this.invitationId = invitationId;
    }
}
