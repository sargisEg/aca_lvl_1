package com.aca.homework.week16.organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Optional;

public class OrganizationServiceImpl implements OrganizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationServiceImpl.class);
    private final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Organization create(OrganizationCreateParams params) {
        Assert.notNull(params, "params should not be null");
        LOGGER.info("Creating Organization for params - {}", params);

        Organization organization = new Organization(params.getName(), params.getFullAddress());

        final Organization savedOrganization = organizationRepository.save(organization);

        LOGGER.info("Successfully created Organization for params - {} result - {}", params, savedOrganization);
        return savedOrganization;
    }

    @Override
    public Organization getById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("Getting Organization for id - {}", id);

        final Optional<Organization> optionalOrganization = organizationRepository.findById(id);

        if (optionalOrganization.isEmpty()) {
            throw new OrganizationNotFoundException(id);
        }
        final Organization organizationById = optionalOrganization.get();

        LOGGER.info("Successfully got Organization for id - {} result - {}", id, organizationById);
        return organizationById;
    }
}
