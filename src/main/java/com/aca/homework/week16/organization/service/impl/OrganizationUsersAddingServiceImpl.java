package com.aca.homework.week16.organization.service.impl;

import com.aca.homework.week16.organization.OrganizationUsers;
import com.aca.homework.week16.organization.create.params.OrganizationUsersCreateParams;
import com.aca.homework.week16.organization.repository.OrganizationUsersRepository;
import com.aca.homework.week16.organization.service.OrganizationUsersAddingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class OrganizationUsersAddingServiceImpl implements OrganizationUsersAddingService {

    private final static Logger LOGGER = LoggerFactory.getLogger(OrganizationUsersAddingServiceImpl.class);
    private final OrganizationUsersRepository repository;

    public OrganizationUsersAddingServiceImpl(OrganizationUsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrganizationUsers addUserToOrganization(OrganizationUsersCreateParams params) {
        Assert.notNull(params, "params should not be null");
        LOGGER.info("Adding new User - {} in Organization - {}",
                params.getUser(),
                params.getOrganization());

        final OrganizationUsers organizationUsers = new OrganizationUsers(params.getOrganization(), params.getUser());

        final OrganizationUsers saved = repository.save(organizationUsers);

        LOGGER.info("Successfully Added new User - {} in Organization - {}",
                params.getUser(),
                params.getOrganization());
        return saved;

    }
}
