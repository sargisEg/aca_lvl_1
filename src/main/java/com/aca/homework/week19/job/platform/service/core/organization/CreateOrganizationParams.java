package com.aca.homework.week19.job.platform.service.core.organization;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;

public class CreateOrganizationParams {

    private final String name;
    private final LocalDate creationDate;

    public CreateOrganizationParams(String name, LocalDate creationDate) {
        Assert.hasText(
                name,
                "Class - CreateOrganizationParams, method - CreateOrganizationParams(String name, LocalDate creationDate) " +
                        "name should not be null or empty"
        );
        Assert.notNull(
                creationDate,
                "Class - CreateOrganizationParams, method - CreateOrganizationParams(String name, LocalDate creationDate) " +
                        "creation date should not be null"
        );
        this.creationDate = creationDate;
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateOrganizationParams{");
        sb.append("name='").append(name).append('\'');
        sb.append("creationDate='").append(creationDate).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateOrganizationParams)) return false;
        CreateOrganizationParams that = (CreateOrganizationParams) o;
        return Objects.equals(name, that.name) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creationDate);
    }
}
