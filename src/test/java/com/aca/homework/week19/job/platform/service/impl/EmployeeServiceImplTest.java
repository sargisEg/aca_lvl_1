package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Employee;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.repository.EmployeeRepository;
import com.aca.homework.week19.job.platform.service.core.organization.CreateEmployerParams;
import com.aca.homework.week19.job.platform.service.core.organization.EmployeeService;
import com.aca.homework.week19.job.platform.service.core.organization.OrganizationService;
import com.aca.homework.week19.job.platform.service.core.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    private EmployeeService testSubject;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private OrganizationService organizationService;

    @Mock
    private UserService userService;

    @BeforeEach
    public void init() {
        testSubject = new EmployeeServiceImpl(employeeRepository, userService, organizationService);
    }

    @Test
    public void testCreateWhenParamsIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.create(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testFindByOrganizationIdWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.findByOrganizationId(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCreateWhenUserNotFound() {
        when(userService.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> testSubject.create(new CreateEmployerParams(1L, 3L)))
                .isExactlyInstanceOf(UserNotFoundException.class);

        verify(userService).findById(1L);
        verifyNoMoreInteractions(employeeRepository, userService, organizationService);
    }

    @Test
    public void testCreateWhenOrganizationNotFound() {
        when(organizationService.findById(2L)).thenReturn(Optional.empty());
        when(userService.findById(1L)).thenReturn(Optional.of(new User()));

        Assertions.assertThatThrownBy(() -> testSubject.create(new CreateEmployerParams(1L, 2L)))
                .isExactlyInstanceOf(OrganizationNotFoundException.class);

        verify(organizationService).findById(2L);
        verify(userService).findById(1L);
        verifyNoMoreInteractions(employeeRepository, userService, organizationService);
    }

    @Test
    public void testCreate() {
        final User user = new User("username", "name", false);
        user.setId(1L);
        when(userService.findById(1L)).thenReturn(Optional.of(user));

        final Organization organization = new Organization("name", LocalDate.of(2000, 10, 10));
        organization.setId(2L);
        when(organizationService.findById(2L)).thenReturn(Optional.of(organization));

        final Employee employee = new Employee(organization, user);
        employee.setId(1L);
        when(employeeRepository.save(new Employee(organization, user)))
                .thenReturn(employee);

        final Employee expectedResult = new Employee(organization, user);
        expectedResult.setId(1L);
        final Employee actualResult = testSubject.create(new CreateEmployerParams(1L, 2L));

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);

        verify(organizationService).findById(2L);
        verify(userService).findById(1L);
        verify(employeeRepository).save(new Employee(organization, user));
        verifyNoMoreInteractions(organizationService, userService, employeeRepository);
    }

    @Test
    public void testFindByOrganizationId() {
        final Employee employee = new Employee(
                new Organization("name", LocalDate.now()),
                new User("username", "name", false)
        );
        when(employeeRepository.findByOrganizationId(1L)).thenReturn(List.of(employee));

        Assertions.assertThat(testSubject.findByOrganizationId(1L))
                .isEqualTo(List.of(employee));

        verify(employeeRepository).findByOrganizationId(1L);
        verifyNoMoreInteractions(employeeRepository, organizationService, userService);
    }
}