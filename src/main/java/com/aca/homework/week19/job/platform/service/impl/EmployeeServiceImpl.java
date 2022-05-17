package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Employee;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.repository.EmployeeRepository;
import com.aca.homework.week19.job.platform.service.core.organization.CreateEmployerParams;
import com.aca.homework.week19.job.platform.service.core.organization.EmployeeService;
import com.aca.homework.week19.job.platform.service.core.organization.OrganizationService;
import com.aca.homework.week19.job.platform.service.core.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;
    private final UserService userService;
    private final OrganizationService organizationService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, UserService userService, OrganizationService organizationService) {
        this.employeeRepository = employeeRepository;
        this.userService = userService;
        this.organizationService = organizationService;
    }

    @Override
    public Employee create(CreateEmployerParams params) {
        Assert.notNull(
                params,
                "Class - EmployerServiceImpl, method - create(CreateEmployerParams params) " +
                        "params should not be null"
        );
        LOGGER.info("Creating employer with params - {}", params);

        final Optional<User> optionalUser = userService.findById(params.getUserId());
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException(params.getUserId());
        }

        final Optional<Organization> optionalOrganization = organizationService.findById(params.getOrganizationId());
        if (optionalOrganization.isEmpty()) {
            throw new OrganizationNotFoundException(params.getOrganizationId());
        }

        final Employee employeeFromParams = new Employee(
                optionalOrganization.get(),
                optionalUser.get()
        );

        final Employee employee = employeeRepository.save(employeeFromParams);

        LOGGER.info("Successfully created employer with params - {}, result - {}", params, employee);
        return employee;
    }

    @Override
    public List<Employee> findByOrganizationId(Long id) {
        Assert.notNull(
                id,
                "Class - EmployerServiceImpl, findByOrganizationId(Long id) " +
                        "id should not be null"
        );
        LOGGER.info("Finding users with organization id - {}", id);

        final List<Employee> employees = employeeRepository.findByOrganizationId(id);

        LOGGER.info("Successfully found users with organization id - {}, result - {}", id, employees);
        return employees;
    }
}
