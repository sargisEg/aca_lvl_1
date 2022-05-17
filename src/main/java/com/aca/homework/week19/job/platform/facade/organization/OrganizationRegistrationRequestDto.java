package com.aca.homework.week19.job.platform.facade.organization;

import org.springframework.util.Assert;

import java.util.Objects;

public final class OrganizationRegistrationRequestDto {

    private String name;

    public OrganizationRegistrationRequestDto(String name) {
        Assert.hasText(
                name,
                "Class - OrganizationRegistrationRequestDto, method - OrganizationRegistrationRequestDto(String name) " +
                        "name should not be null or empty"
        );
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrganizationRegistrationRequestDto{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationRegistrationRequestDto)) return false;
        OrganizationRegistrationRequestDto that = (OrganizationRegistrationRequestDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
