package com.aca.homework.week16.organization.service;

import com.aca.homework.week16.organization.OrganizationUsers;
import com.aca.homework.week16.organization.create.params.OrganizationUsersCreateParams;
import org.springframework.stereotype.Service;

@Service
public interface OrganizationUsersAddingService {

    OrganizationUsers addUserToOrganization(OrganizationUsersCreateParams params);
}
