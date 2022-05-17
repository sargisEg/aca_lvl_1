package com.aca.homework.week19.job.platform.service.core.invitation;

import com.aca.homework.week19.job.platform.entity.InvitationState;
import org.springframework.util.Assert;

import java.util.Objects;

public class UpdateInvitationParams {

    private final Long id;
    private final Long organizationId;
    private final Long userId;
    private final InvitationState invitationState;

    public UpdateInvitationParams(Long id, Long organizationId, Long userId, InvitationState invitationState) {
        Assert.notNull(
                id,
                "Class - UpdateInvitationParams, method - UpdateInvitationParams(Long id, Long organizationId, Long userId, InvitationState invitationState) " +
                        "id should not be null"
        );
        Assert.notNull(
                organizationId,
                "Class - UpdateInvitationParams, method - UpdateInvitationParams(Long id, Long organizationId, Long userId, InvitationState invitationState) " +
                        "organizationId should not be null"
        );
        Assert.notNull(
                userId,
                "Class - UpdateInvitationParams, method - UpdateInvitationParams(Long id, Long organizationId, Long userId, InvitationState invitationState) " +
                        "userId should not be null"
        );
        Assert.notNull(
                invitationState,
                "Class - UpdateInvitationParams, method - UpdateInvitationParams(Long id, Long organizationId, Long userId, InvitationState invitationState) " +
                        "invitationState should not be null"
        );
        this.id = id;
        this.organizationId = organizationId;
        this.userId = userId;
        this.invitationState = invitationState;
    }

    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UpdateInvitationParams{");
        sb.append("id=").append(id);
        sb.append(", organizationId=").append(organizationId);
        sb.append(", userId=").append(userId);
        sb.append(", invitationState=").append(invitationState);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateInvitationParams)) return false;
        UpdateInvitationParams that = (UpdateInvitationParams) o;
        return Objects.equals(id, that.id) && Objects.equals(organizationId, that.organizationId) && Objects.equals(userId, that.userId) && invitationState == that.invitationState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, organizationId, userId, invitationState);
    }
}
