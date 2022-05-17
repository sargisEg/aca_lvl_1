package com.aca.homework.week19.job.platform.service.impl;

public class OrganizationNotFoundException extends RuntimeException {
    public OrganizationNotFoundException(Long organizationId) {
        super("Not found organization with id - " + organizationId);
    }
}
