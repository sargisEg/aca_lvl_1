package com.aca.homework.week19.job.platform.facade.organization;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public final class OrganizationDto {

    private Long id;
    private String name;
    private LocalDate creationDate;

    private List<String> errors;

    public OrganizationDto(List<String> errors) {
        Assert.notNull(
                errors,
                "Class - OrganizationDto, method - OrganizationDto(List<String> errors) " +
                        "errors should not be null"
        );
        this.errors = errors;
    }

    public OrganizationDto(Long id, String name, LocalDate creationDate) {
        Assert.notNull(
                id,
                "Class - OrganizationDto, method - OrganizationDto(Long id, String name, LocalDate creationDate) " +
                        "id should not be null"
        );
        Assert.hasText(
                name,
                "Class - OrganizationDto, method - OrganizationDto(Long id, String name, LocalDate creationDate) " +
                        "name should not be null or empty"
        );
        Assert.notNull(
                creationDate,
                "Class - OrganizationDto, method - OrganizationDto(Long id, String name, LocalDate creationDate) " +
                        "creation date should not be null"
        );
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrganizationDto{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", creationDate=").append(creationDate);
        sb.append(", errors=").append(errors);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationDto)) return false;
        OrganizationDto that = (OrganizationDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(errors, that.errors) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creationDate, errors);
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
