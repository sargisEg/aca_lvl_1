package com.aca.homework.week19.job.platform.service.core.organization;

import com.aca.homework.week19.job.platform.entity.Organization;

import java.util.Optional;

public interface OrganizationService {

    Organization create(CreateOrganizationParams params);

    Optional<Organization> findById(Long id);

    Optional<Organization> findByName(String name);
}
