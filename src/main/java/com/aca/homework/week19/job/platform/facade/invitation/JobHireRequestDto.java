package com.aca.homework.week19.job.platform.facade.invitation;

import org.springframework.util.Assert;

import java.util.Objects;

public final class JobHireRequestDto {

    private Long invitationId;

    public JobHireRequestDto(Long invitationId) {
        Assert.notNull(
                invitationId,
                "Class - JobHireRequestDto, method - JobHireRequestDto(Long invitationId) " +
                        "invitationId should not be null"
        );
        this.invitationId = invitationId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JobHireRequestDto{");
        sb.append("invitationId=").append(invitationId);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobHireRequestDto)) return false;
        JobHireRequestDto that = (JobHireRequestDto) o;
        return Objects.equals(invitationId, that.invitationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invitationId);
    }

    public Long getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Long invitationId) {
        this.invitationId = invitationId;
    }
}
