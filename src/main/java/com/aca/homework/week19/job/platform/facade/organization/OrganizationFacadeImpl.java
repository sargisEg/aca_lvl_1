package com.aca.homework.week19.job.platform.facade.organization;

import com.aca.homework.week19.job.platform.entity.Employee;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import com.aca.homework.week19.job.platform.facade.user.UserMapper;
import com.aca.homework.week19.job.platform.service.core.organization.CreateOrganizationParams;
import com.aca.homework.week19.job.platform.service.core.organization.EmployeeService;
import com.aca.homework.week19.job.platform.service.core.organization.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class OrganizationFacadeImpl implements OrganizationFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationFacadeImpl.class);

    private final OrganizationService organizationService;
    private final OrganizationMapper organizationMapper;
    private final EmployeeService employeeService;
    private final UserMapper userMapper;

    public OrganizationFacadeImpl(OrganizationService organizationService, OrganizationMapper organizationMapper, EmployeeService employeeService, UserMapper userMapper) {
        this.organizationService = organizationService;
        this.organizationMapper = organizationMapper;
        this.employeeService = employeeService;
        this.userMapper = userMapper;
    }

    @Override
    public OrganizationDetailsDto register(OrganizationRegistrationRequestDto dto) {
        Assert.notNull(
                dto,
                "class - OrganizationFacadeImpl, method - register(OrganizationRegistrationRequestDto dto) " +
                        "dto should not be null"
        );
        LOGGER.info("Registering an organization for provided request - {}", dto);

        final Optional<Organization> optionalOrganization = organizationService.findByName(dto.getName());

        if (optionalOrganization.isPresent()) {
            return new OrganizationDetailsDto(List.of("Organization with name - " + dto.getName() + " already exist"));
        }

        final Organization organization = organizationService.create(new CreateOrganizationParams(
                dto.getName(),
                LocalDate.now()
        ));

        final OrganizationDetailsDto organizationDetailsDto = new OrganizationDetailsDto(organizationMapper.map(organization), Collections.emptyList());

        LOGGER.info("Successfully registered an organization for provided request - {}, response - {}", dto, organizationDetailsDto);
        return organizationDetailsDto;
    }

    @Override
    public OrganizationDetailsDto getOrganizationDetails(Long organizationId) {
        Assert.notNull(
                organizationId,
                "class - OrganizationFacadeImpl, method - getOrganizationDetails(Long organizationId) " +
                        "organizationId should not be null"
        );
        LOGGER.info("Getting organization details for organization with id - {}", organizationId);

        final Optional<Organization> optionalOrganization = organizationService.findById(organizationId);
        if (optionalOrganization.isEmpty()) {
            return new OrganizationDetailsDto(List.of("Not found organization with id - " + organizationId));
        }

        final List<Employee> employees = employeeService.findByOrganizationId(organizationId);
        final List<UserDetailsDto> userDetailsDtos = new LinkedList<>();
        employees.forEach(employer -> {
            userDetailsDtos.add(userMapper.map(employer.getUser()));
        });

        final OrganizationDetailsDto detailsDto = new OrganizationDetailsDto(
                organizationMapper.map(optionalOrganization.get()),
                userDetailsDtos
        );

        LOGGER.info("Successfully got organization details for organization with id - {}, result - {}", organizationId, detailsDto);
        return detailsDto;
    }
}
