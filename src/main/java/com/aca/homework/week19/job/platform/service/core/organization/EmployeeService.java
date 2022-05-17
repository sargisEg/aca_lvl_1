package com.aca.homework.week19.job.platform.service.core.organization;

import com.aca.homework.week19.job.platform.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee create(CreateEmployerParams params);

    List<Employee> findByOrganizationId(Long id);
}
