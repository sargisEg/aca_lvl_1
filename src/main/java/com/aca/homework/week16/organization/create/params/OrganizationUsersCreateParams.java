package com.aca.homework.week16.organization.create.params;

import com.aca.homework.week16.organization.Organization;
import com.aca.homework.week16.organization.User;

public class OrganizationUsersCreateParams {

    private final Organization organization;

    private final User user;

    public OrganizationUsersCreateParams(Organization organization, User user) {
        this.organization = organization;
        this.user = user;
    }

    public Organization getOrganization() {
        return organization;
    }

    public User getUser() {
        return user;
    }
}
