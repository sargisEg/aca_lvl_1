package com.aca.homework.week19.job.platform.service.core.invitation;

import com.aca.homework.week19.job.platform.entity.InvitationState;
import org.springframework.util.Assert;

import java.util.Objects;

public class CreateInvitationParams {

    private final Long organizationId;
    private final Long userId;
    private final InvitationState invitationState;

    public CreateInvitationParams(Long organizationId, Long userId, InvitationState invitationState) {
        Assert.notNull(
                organizationId,
                "Class - CreateInvitationParams, method - CreateInvitationParams(Long organizationId, Long userId, InvitationState invitationState) " +
                        "organizationId should not be null"
        );
        Assert.notNull(
                userId,
                "Class - CreateInvitationParams, method - CreateInvitationParams(Long organizationId, Long userId, InvitationState invitationState) " +
                        "userId should not be null"
        );
        Assert.notNull(
                invitationState,
                "Class - CreateInvitationParams, method - CreateInvitationParams(Long organizationId, Long userId, InvitationState invitationState) " +
                        "invitationState should not be null"
        );
        this.organizationId = organizationId;
        this.userId = userId;
        this.invitationState = invitationState;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateInvitationParams{");
        sb.append("organizationId=").append(organizationId);
        sb.append(", userId=").append(userId);
        sb.append(", invitationState=").append(invitationState);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateInvitationParams)) return false;
        CreateInvitationParams that = (CreateInvitationParams) o;
        return Objects.equals(organizationId, that.organizationId) && Objects.equals(userId, that.userId) && invitationState == that.invitationState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationId, userId, invitationState);
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public Long getUserId() {
        return userId;
    }

    public InvitationState getInvitationState() {
        return invitationState;
    }
}
