package com.aca.homework.week19.job.platform.facade.invitation;

import com.aca.homework.week19.job.platform.entity.Invitation;
import com.aca.homework.week19.job.platform.entity.InvitationState;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationDto;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationMapper;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import com.aca.homework.week19.job.platform.facade.user.UserMapper;
import com.aca.homework.week19.job.platform.service.core.invitation.InvitationService;
import com.aca.homework.week19.job.platform.service.core.organization.CreateEmployerParams;
import com.aca.homework.week19.job.platform.service.core.organization.EmployeeService;
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
class JobFacadeImplTest {

    private JobFacade testSubject;

    @Mock
    private InvitationService invitationService;

    @Mock
    private EmployeeService employeeService;

    @Mock
    private OrganizationMapper organizationMapper;

    @Mock
    private UserMapper userMapper;

    @BeforeEach
    public void init() {
        testSubject = new JobFacadeImpl(
                invitationService,
                employeeService,
                organizationMapper,
                userMapper

        );
    }

    @Test
    public void testHireWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.hire(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testHireWhenInvitationNotFound() {
        when(invitationService.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThat(testSubject.hire(new JobHireRequestDto(1L)))
                        .isEqualTo(new JobHireResponseDto(
                                List.of("Not found invitation with id - 1")
                        ));

        verify(invitationService).findById(1L);
        verifyNoMoreInteractions(invitationService);
    }

    @Test
    public void testHireWhenInvitationIsNotAccepted() {
        when(invitationService.findById(1L))
                .thenReturn(Optional.of(new Invitation(InvitationState.REJECTED, null, null)));

        Assertions.assertThat(testSubject.hire(new JobHireRequestDto(1L)))
                        .isEqualTo(new JobHireResponseDto(
                                List.of("Invitation with id - 1 is not accepted")
                        ));

        verify(invitationService).findById(1L);
        verifyNoMoreInteractions(invitationService);
    }

    @Test
    public void testHire() {
        final User user = new User("u", "n", false);
        user.setId(1L);
        final Organization organization = new Organization("n", LocalDate.now());
        organization.setId(1L);
        final Invitation invitation = new Invitation(InvitationState.ACCEPTED, organization, user);
        invitation.setId(1L);
        when(invitationService.findById(1L))
                .thenReturn(Optional.of(invitation));

        final UserDetailsDto userDetailsDto = new UserDetailsDto(
                1L,
                "u",
                "n",
                false
        );
        when(userMapper.map(user)).thenReturn(userDetailsDto);

        final OrganizationDto organizationDto = new OrganizationDto(
                1L,
                "n",
                LocalDate.now()
        );
        when(organizationMapper.map(organization)).thenReturn(
                organizationDto
        );

        Assertions.assertThat(testSubject.hire(new JobHireRequestDto(1L)))
                        .isEqualTo(new JobHireResponseDto(
                                userDetailsDto,
                                organizationDto
                        ));

        verify(invitationService).findById(1L);
        verify(employeeService).create(new CreateEmployerParams(1L, 1L));
        verify(userMapper).map(user);
        verify(organizationMapper).map(organization);
        verifyNoMoreInteractions(
                invitationService,
                employeeService,
                userMapper,
                organizationMapper
        );
    }
}