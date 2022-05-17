package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.repository.OrganizationRepository;
import com.aca.homework.week19.job.platform.service.core.organization.CreateOrganizationParams;
import com.aca.homework.week19.job.platform.service.core.organization.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Organization create(CreateOrganizationParams params) {
        Assert.notNull(
                params,
                "Class - OrganizationServiceImpl, method - create(OrganizationServiceImpl params) " +
                        "params should not be null"
        );
        LOGGER.info("Creating organization with paras - {}", params);

        final Organization organizationFromParams = new Organization(params.getName(), params.getCreationDate());

        final Organization organization = organizationRepository.save(organizationFromParams);

        LOGGER.info("Successfully created organization with paras - {}, result - {}", params, organization);
        return organization;
    }

    @Override
    public Optional<Organization> findById(Long id) {
        Assert.notNull(
                id,
                "Class - OrganizationServiceImpl, method - findById(Long id) id should not be null"
        );
        LOGGER.info("Finding organization with id - {}", id);

        final Optional<Organization> optionalOrganization = organizationRepository.findById(id);

        LOGGER.info("Successfully found organization with id - {}, result - {}", id, optionalOrganization);
        return optionalOrganization;
    }

    @Override
    public Optional<Organization> findByName(String name) {
        Assert.hasText(
                name,
                "Class - OrganizationServiceImpl, method - findByName(String name) name should not be null"
        );
        LOGGER.info("Finding organization with name - {}", name);

        final Optional<Organization> optionalOrganization = organizationRepository.findByName(name);

        LOGGER.info("Successfully found organization with name - {}, result - {}", name, optionalOrganization);
        return optionalOrganization;
    }
}
