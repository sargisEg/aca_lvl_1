package com.aca.homework.week19.job.platform.facade.organization;

import com.aca.homework.week19.job.platform.entity.Employee;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import com.aca.homework.week19.job.platform.facade.user.UserMapper;
import com.aca.homework.week19.job.platform.service.core.organization.CreateOrganizationParams;
import com.aca.homework.week19.job.platform.service.core.organization.EmployeeService;
import com.aca.homework.week19.job.platform.service.core.organization.OrganizationService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrganizationFacadeImplTest {

    private OrganizationFacadeImpl testSubject;

    @Mock
    private OrganizationService organizationService;

    @Mock
    private OrganizationMapper organizationMapper;

    @Mock
    private EmployeeService employeeService;

    @Mock
    private UserMapper userMapper;

    @BeforeEach
    public void init() {
        testSubject = new OrganizationFacadeImpl(
                organizationService,
                organizationMapper,
                employeeService,
                userMapper
        );
    }

    @Test
    public void testRegisterWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.register(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testGetOrganizationDetailsWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.getOrganizationDetails(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testRegisterWhenAlreadyExist() {
        when(organizationService.findByName("name")).thenReturn(Optional.of(new Organization()));
        Assertions.assertThat(testSubject.register(new OrganizationRegistrationRequestDto("name")))
                .isEqualTo(new OrganizationDetailsDto(List.of("Organization with name - name already exist")));

        verify(organizationService).findByName("name");
        verifyNoMoreInteractions(
                organizationService,
                organizationMapper,
                employeeService,
                userMapper
        );
    }

    @Test
    public void testRegister() {
        when(organizationService.findByName("name")).thenReturn(Optional.empty());

        final Organization organization = new Organization("name", LocalDate.of(2000, 10, 10));
        organization.setId(1L);
        when(
                organizationService.create(new CreateOrganizationParams(
                        "name",
                        LocalDate.now()
                ))
        ).thenReturn(organization);

        when(organizationMapper.map(organization))
                .thenReturn(new OrganizationDto(1L, "name", LocalDate.of(2000, 10, 10)));

        Assertions.assertThat(testSubject.register(new OrganizationRegistrationRequestDto("name")))
                        .isEqualTo(
                                new OrganizationDetailsDto(
                                        new OrganizationDto(1L, "name", LocalDate.of(2000, 10, 10)),
                                        Collections.emptyList()
                                )
                        );

        verify(organizationService).findByName("name");
        verify(organizationService).create(new CreateOrganizationParams(
                "name",
                LocalDate.now()
        ));
        verify(organizationMapper).map(organization);
        verifyNoMoreInteractions(
                organizationService,
                organizationMapper,
                employeeService,
                userMapper
        );
    }

    @Test
    public void testGetOrganizationDetailsWhenNotFound() {
        when(organizationService.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.getOrganizationDetails(1L))
                .isEqualTo(new OrganizationDetailsDto(List.of("Not found organization with id - 1")));

        verify(organizationService).findById(1L);
        verifyNoMoreInteractions(
                organizationService,
                organizationMapper,
                employeeService,
                userMapper
        );
    }

    @Test
    public void testGetOrganizationDetails() {

        final Organization organization = new Organization("name", LocalDate.of(2000, 10, 10));
        organization.setId(1L);
        when(organizationService.findById(1L)).thenReturn(Optional.of(organization));

        final User user = new User("username", "name", false);
        user.setId(1L);
        final Employee e1 = new Employee(organization, user);
        when(employeeService.findByOrganizationId(1L))
                .thenReturn(List.of(e1));

        when(userMapper.map(user))
                .thenReturn(new UserDetailsDto(1L, "username", "name", false));

        when(organizationMapper.map(organization))
                .thenReturn(new OrganizationDto(1L, "name", LocalDate.of(2000, 10, 10)));

        Assertions.assertThat(testSubject.getOrganizationDetails(1L))
                .isEqualTo(new OrganizationDetailsDto(
                        new OrganizationDto(1L, "name", LocalDate.of(2000, 10, 10)),
                        List.of(new UserDetailsDto(
                                1L,
                                "username",
                                "name",
                                false
                        ))
                ));

        verify(organizationService).findById(1L);
        verify(employeeService).findByOrganizationId(1L);
        verify(organizationMapper).map(organization);
        verify(userMapper).map(user);
        verifyNoMoreInteractions(
                organizationService,
                organizationMapper,
                employeeService,
                userMapper
        );
    }
}