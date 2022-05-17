package com.aca.homework.week19.job.platform.facade.invitation;

import com.aca.homework.week19.job.platform.entity.InvitationState;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationDetailsDto;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationDto;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public final class InvitationDetailsDto {

    private Long id;
    private InvitationState invitationState;
    private OrganizationDto organizationDto;
    private UserDetailsDto userDetailsDto;

    private List<String> errors;

    public InvitationDetailsDto(List<String> errors) {
        Assert.notNull(
                errors,
                "Class - InvitationDetailsDto, method - InvitationDetailsDto(List<String> errors) " +
                        "errors should not be null"
        );
        this.errors = errors;
    }

    public InvitationDetailsDto(Long id, InvitationState invitationState, OrganizationDto organizationDto, UserDetailsDto userDetailsDto) {
        Assert.notNull(
                id,
                "Class - InvitationDetailsDto, method - InvitationDetailsDto(Long id, InvitationState invitationState, OrganizationDetailsDto organizationDto, UserDetailsDto userDetailsDto) " +
                        "id should not be null"
        );
        Assert.notNull(
                invitationState,
                "Class - InvitationDetailsDto, method - InvitationDetailsDto(Long id, InvitationState invitationState, OrganizationDetailsDto organizationDto, UserDetailsDto userDetailsDto) " +
                        "invitationState should not be null"
        );
        Assert.notNull(
                organizationDto,
                "Class - InvitationDetailsDto, method - InvitationDetailsDto(Long id, InvitationState invitationState, OrganizationDetailsDto organizationDto, UserDetailsDto userDetailsDto) " +
                        "organizationDto should not be null"
        );
        Assert.notNull(
                userDetailsDto,
                "Class - InvitationDetailsDto, method - InvitationDetailsDto(Long id, InvitationState invitationState, OrganizationDetailsDto organizationDto, UserDetailsDto userDetailsDto) " +
                        "userDetailsDto should not be null"
        );
        this.id = id;
        this.invitationState = invitationState;
        this.organizationDto = organizationDto;
        this.userDetailsDto = userDetailsDto;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InvitationDetailsDto{");
        sb.append("id=").append(id);
        sb.append(", invitationState=").append(invitationState);
        sb.append(", organizationDetailsDto=").append(organizationDto);
        sb.append(", userDetailsDto=").append(userDetailsDto);
        sb.append(", errors=").append(errors);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvitationDetailsDto)) return false;
        InvitationDetailsDto that = (InvitationDetailsDto) o;
        return Objects.equals(id, that.id) && invitationState == that.invitationState && Objects.equals(organizationDto, that.organizationDto) && Objects.equals(userDetailsDto, that.userDetailsDto) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invitationState, organizationDto, userDetailsDto, errors);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InvitationState getInvitationState() {
        return invitationState;
    }

    public void setInvitationState(InvitationState invitationState) {
        this.invitationState = invitationState;
    }

    public OrganizationDto getOrganizationDto() {
        return organizationDto;
    }

    public void setOrganizationDto(OrganizationDto organizationDto) {
        this.organizationDto = organizationDto;
    }

    public UserDetailsDto getUserDetailsDto() {
        return userDetailsDto;
    }

    public void setUserDetailsDto(UserDetailsDto userDetailsDto) {
        this.userDetailsDto = userDetailsDto;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
