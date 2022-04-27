package com.aca.homework.week16.organization;

public class OrganizationNotFoundException extends RuntimeException {
    public OrganizationNotFoundException(Long id) {
        super("Not found organization with id: " + id);
    }
}
