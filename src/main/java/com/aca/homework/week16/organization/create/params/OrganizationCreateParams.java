package com.aca.homework.week16.organization.create.params;

import org.springframework.util.Assert;

public class OrganizationCreateParams {

    private final String name;
    private final String fullAddress;

    public OrganizationCreateParams(String name, String fullAddress) {
        Assert.hasText(name, "Name should not be null or empty");
        Assert.hasText(fullAddress, "Full address should not be null or empty");
        this.name = name;
        this.fullAddress = fullAddress;
    }

    public String getName() {
        return name;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrganizationCreateParams{");
        sb.append("name='").append(name).append('\'');
        sb.append(", fullAddress='").append(fullAddress).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
