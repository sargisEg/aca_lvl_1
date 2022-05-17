package com.aca.homework.week19.job.platform.facade.organization;

public interface OrganizationFacade {

    OrganizationDetailsDto register(OrganizationRegistrationRequestDto dto);

    OrganizationDetailsDto getOrganizationDetails(Long organizationId);

}
