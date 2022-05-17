package com.aca.homework.week19.job.platform.facade.invitation;

import com.aca.homework.week19.job.platform.facade.organization.OrganizationDto;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public final class JobHireResponseDto {

    private UserDetailsDto userDetailsDto;
    private OrganizationDto organizationDto;

    private List<String> errors;

    public JobHireResponseDto(List<String> errors) {
        this.errors = errors;
    }

    public JobHireResponseDto(UserDetailsDto userDetailsDto, OrganizationDto organizationDto) {
        Assert.notNull(
                userDetailsDto,
                "Class - JobHireResponseDto, method - JobHireResponseDto(UserDetailsDto userDetailsDto, OrganizationDto organizationDto) " +
                        "userDetailsDto should not be null"
        );
        Assert.notNull(
                organizationDto,
                "Class - JobHireResponseDto, method - JobHireResponseDto(UserDetailsDto userDetailsDto, OrganizationDto organizationDto) " +
                        "organizationDto should not be null"
        );
        this.userDetailsDto = userDetailsDto;
        this.organizationDto = organizationDto;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JobHireResponseDto{");
        sb.append("userDetailsDto=").append(userDetailsDto);
        sb.append(", organizationDto=").append(organizationDto);
        sb.append(", errors=").append(errors);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobHireResponseDto)) return false;
        JobHireResponseDto that = (JobHireResponseDto) o;
        return Objects.equals(userDetailsDto, that.userDetailsDto) && Objects.equals(organizationDto, that.organizationDto) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userDetailsDto, organizationDto, errors);
    }

    public UserDetailsDto getUserDetailsDto() {
        return userDetailsDto;
    }

    public void setUserDetailsDto(UserDetailsDto userDetailsDto) {
        this.userDetailsDto = userDetailsDto;
    }

    public OrganizationDto getOrganizationDto() {
        return organizationDto;
    }

    public void setOrganizationDto(OrganizationDto organizationDto) {
        this.organizationDto = organizationDto;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
