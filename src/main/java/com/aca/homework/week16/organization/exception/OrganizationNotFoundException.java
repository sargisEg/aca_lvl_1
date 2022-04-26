package com.aca.homework.week16.organization.exception;

public class OrganizationNotFoundException extends RuntimeException {
    public OrganizationNotFoundException(Long id) {
        super("Not found organization with id: " + id);
    }
}
