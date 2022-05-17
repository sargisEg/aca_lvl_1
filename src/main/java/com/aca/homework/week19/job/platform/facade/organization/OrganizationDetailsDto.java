package com.aca.homework.week19.job.platform.facade.organization;

import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public final class OrganizationDetailsDto {

    private OrganizationDto organizationDto;
    private List<UserDetailsDto> employees;

    private List<String> errors;

    public OrganizationDetailsDto(List<String> errors) {
        Assert.notNull(
                errors,
                "Class - OrganizationDetailsDto, method - OrganizationDetailsDto(List<String> errors) " +
                        "errors should not be null"
        );
        this.errors = errors;
    }

    public OrganizationDetailsDto(OrganizationDto organizationDto, List<UserDetailsDto> employees) {
        Assert.notNull(
                organizationDto,
                "Class - OrganizationDetailsDto, method - OrganizationDetailsDto(OrganizationDto organizationDto, UserDetailsDto userDetailsDto) " +
                        "organization dto should not be null"
        );
        Assert.notNull(
                employees,
                "Class - OrganizationDetailsDto, method - OrganizationDetailsDto(OrganizationDto organizationDto, UserDetailsDto userDetailsDto) " +
                        "employees should not be null"
        );
        this.organizationDto = organizationDto;
        this.employees = employees;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrganizationDetailsDto{");
        sb.append("organizationDto=").append(organizationDto);
        sb.append(", userDetailsDto=").append(employees);
        sb.append(", errors=").append(errors);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationDetailsDto)) return false;
        OrganizationDetailsDto that = (OrganizationDetailsDto) o;
        return Objects.equals(organizationDto, that.organizationDto) && Objects.equals(employees, that.employees) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationDto, employees, errors);
    }

    public OrganizationDto getOrganizationDto() {
        return organizationDto;
    }

    public void setOrganizationDto(OrganizationDto organizationDto) {
        this.organizationDto = organizationDto;
    }

    public List<UserDetailsDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<UserDetailsDto> employees) {
        this.employees = employees;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
