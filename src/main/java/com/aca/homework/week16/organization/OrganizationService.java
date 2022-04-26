package com.aca.homework.week16.organization;

import org.springframework.stereotype.Service;

@Service
public interface OrganizationService {

    Organization create(OrganizationCreateParams params);

    Organization getById(Long id);
}
