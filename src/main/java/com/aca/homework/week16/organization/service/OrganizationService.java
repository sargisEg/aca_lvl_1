package com.aca.homework.week16.organization.service;

import com.aca.homework.week16.organization.Organization;
import com.aca.homework.week16.organization.OrganizationUsers;
import com.aca.homework.week16.organization.create.params.OrganizationCreateParams;
import com.aca.homework.week16.organization.create.params.OrganizationUsersCreateParams;
import org.springframework.stereotype.Service;

@Service
public interface OrganizationService {

    Organization create(OrganizationCreateParams params);

    Organization getById(Long id);
}
