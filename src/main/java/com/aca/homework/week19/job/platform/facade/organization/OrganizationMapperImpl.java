package com.aca.homework.week19.job.platform.facade.organization;

import com.aca.homework.week19.job.platform.entity.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class OrganizationMapperImpl implements OrganizationMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationMapperImpl.class);

    @Override
    public OrganizationDto map(Organization organization) {
        Assert.notNull(
                organization,
                "Class - OrganizationMapperImpl, method - OrganizationDto map(Organization organization) " +
                        "organization should not be null"
        );
        LOGGER.debug("Creating Organization dto from Organization - {}", organization);
        final OrganizationDto organizationDto = new OrganizationDto(organization.getId(), organization.getName(), organization.getCreationDate());
        LOGGER.debug("Successfully created Organization dto from Organization - {}, result - {}", organization, organizationDto);
        return organizationDto;
    }
}
