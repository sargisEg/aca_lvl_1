package com.aca.homework.week19.job.platform.facade.invitation;

import com.aca.homework.week19.job.platform.entity.*;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationDto;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationMapper;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import com.aca.homework.week19.job.platform.facade.user.UserFacadeImpl;
import com.aca.homework.week19.job.platform.facade.user.UserMapper;
import com.aca.homework.week19.job.platform.service.core.invitation.CreateInvitationParams;
import com.aca.homework.week19.job.platform.service.core.invitation.InvitationService;
import com.aca.homework.week19.job.platform.service.core.invitation.UpdateInvitationParams;
import com.aca.homework.week19.job.platform.service.core.organization.CreateEmployerParams;
import com.aca.homework.week19.job.platform.service.core.organization.EmployeeService;
import com.aca.homework.week19.job.platform.service.core.organization.OrganizationService;
import com.aca.homework.week19.job.platform.service.core.user.UpdateUserParams;
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
class InvitationFacadeImplTest {

    private InvitationFacade testSubject;

    @Mock
    private InvitationService invitationService;

    @Mock
    private UserService userService;

    @Mock
    private OrganizationService organizationService;

    @Mock
    private OrganizationMapper organizationMapper;

    @Mock
    private UserMapper userMapper;

    @BeforeEach
    public void init() {
        testSubject = new InvitationFacadeImpl(
                invitationService,
                userService,
                organizationService,
                organizationMapper,
                userMapper
        );
    }

    @Test
    public void testSendInvitationWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.sendInvitation(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testAcceptInvitationWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.acceptInvitation(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testRejectInvitationWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.rejectInvitation(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testSendInvitationWhenUserNotFound() {
        when(userService.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThat(testSubject.sendInvitation(
                new InvitationRequestDto(1L, 1L)
        )).isEqualTo(new InvitationDetailsDto(List.of("Not found user with id - 1")));

        verify(userService).findById(1L);
        verifyNoMoreInteractions(
                invitationService,
                userService,
                organizationService,
                userMapper,
                organizationMapper
        );
    }

    @Test
    public void testSendInvitationWhenUserNotOpenForOffers() {
        when(userService.findById(1L))
                .thenReturn(Optional.of(new User("u", "n", false)));

        Assertions.assertThat(testSubject.sendInvitation(
                new InvitationRequestDto(1L, 1L)
        )).isEqualTo(new InvitationDetailsDto(
                List.of("User with id - 1 is not open for offers")
        ));

        verify(userService).findById(1L);
        verifyNoMoreInteractions(
                invitationService,
                userService,
                organizationService,
                userMapper,
                organizationMapper
        );
    }

    @Test
    public void testSendInvitationWhenOrganizationNotFound() {
        when(userService.findById(1L))
                .thenReturn(Optional.of(new User("u", "n", true)));

        when(organizationService.findById(1L))
                .thenReturn(Optional.empty());

        Assertions.assertThat(testSubject.sendInvitation(
                new InvitationRequestDto(1L, 1L)
        )).isEqualTo(new InvitationDetailsDto(
                List.of("Not found organization with id - 1")
        ));

        verify(userService).findById(1L);
        verify(organizationService).findById(1L);
        verifyNoMoreInteractions(
                invitationService,
                userService,
                organizationService,
                userMapper,
                organizationMapper
        );
    }

    @Test
    public void testSendInvitation() {
        final User user = new User("u", "n", true);
        user.setId(1L);
        when(userService.findById(1L))
                .thenReturn(Optional.of(user));

        final Organization organization = new Organization("n", LocalDate.of(1111, 11, 11));
        organization.setId(1L);
        when(organizationService.findById(1L))
                .thenReturn(Optional.of(organization));

        final Invitation invitation = new Invitation(InvitationState.PENDING, organization, user);
        invitation.setId(1L);
        when(invitationService.create(new CreateInvitationParams(
                1L,
                1L,
                InvitationState.PENDING
        ))).thenReturn(invitation);

        final OrganizationDto organizationDto = new OrganizationDto(
                1L,
                "n",
                LocalDate.of(1111, 11, 11)
        );
        when(organizationMapper.map(organization))
                .thenReturn(organizationDto);

        final UserDetailsDto userDetailsDto = new UserDetailsDto(
                1L,
                "u",
                "n",
                true
        );
        when(userMapper.map(user))
                .thenReturn(userDetailsDto);

        Assertions.assertThat(testSubject.sendInvitation(
                new InvitationRequestDto(1L, 1L)
        )).isEqualTo(new InvitationDetailsDto(
                1L,
                InvitationState.PENDING,
                organizationDto,
                userDetailsDto
        ));

        verify(userService).findById(1L);
        verify(organizationService).findById(1L);
        verify(invitationService).create(new CreateInvitationParams(
                1L,
                1L,
                InvitationState.PENDING
        ));
        verify(userMapper).map(user);
        verify(organizationMapper).map(organization);
        verifyNoMoreInteractions(
                invitationService,
                userService,
                organizationService,
                userMapper,
                organizationMapper
        );
    }

    @Test
    public void testAcceptInvitationWhenInvitationNotFound() {
        when(invitationService.findById(1L))
                .thenReturn(Optional.empty());

        Assertions.assertThat(testSubject.acceptInvitation(
                new InvitationAcceptDto(
                        1L,
                        1L
                )
        )).isEqualTo(new InvitationDetailsDto(List.of("Not found invitation with id - 1")));

        verify(invitationService).findById(1L);

        verifyNoMoreInteractions(
                invitationService,
                userService,
                organizationService,
                userMapper,
                organizationMapper
        );
    }

    @Test
    public void testAcceptInvitationWhenUserNotFound() {
        final Organization organization = new Organization("n", LocalDate.of(1111, 11, 11));
        organization.setId(1L);
        final User user = new User("u", "n", true);
        user.setId(2L);
        final Invitation invitation = new Invitation(
                InvitationState.PENDING,
                organization,
                user
        );
        invitation.setId(1L);

        when(invitationService.findById(1L))
                .thenReturn(Optional.of(invitation));

        Assertions.assertThat(testSubject.acceptInvitation(
                new InvitationAcceptDto(
                        1L,
                        1L
                )
        )).isEqualTo(new InvitationDetailsDto(List.of(
                "Not found invitation with id - 1 for user with id - 1"
        )));

        verify(invitationService).findById(1L);

        verifyNoMoreInteractions(
                invitationService,
                userService,
                organizationService,
                userMapper,
                organizationMapper
        );
    }

    @Test
    public void testAcceptInvitation() {
        final Organization organization = new Organization("n", LocalDate.of(1111, 11, 11));
        organization.setId(1L);
        final User user = new User("u", "n", true);
        user.setId(1L);
        final Invitation invitation = new Invitation(
                InvitationState.PENDING,
                organization,
                user
        );
        invitation.setId(1L);

        when(invitationService.findById(1L))
                .thenReturn(Optional.of(invitation));

        final User updatedUser = new User("u", "n", false);
        updatedUser.setId(1L);
        when(userService.update(new UpdateUserParams(
                1L,
                "u",
                "n",
                false
        ))).thenReturn(updatedUser);

        final Invitation updatedInvitation = new Invitation(InvitationState.ACCEPTED, organization, updatedUser);
        updatedInvitation.setId(1L);
        when(invitationService.update(new UpdateInvitationParams(
                1L,
                1L,
                1L,
                InvitationState.ACCEPTED
        ))).thenReturn(updatedInvitation);

        final OrganizationDto organizationDto = new OrganizationDto(
                1L,
                "n",
                LocalDate.of(1111, 11, 11)
        );
        when(organizationMapper.map(organization))
                .thenReturn(organizationDto);

        final UserDetailsDto userDetailsDto = new UserDetailsDto(
                1L,
                "u",
                "n",
                false
        );
        when(userMapper.map(updatedUser))
                .thenReturn(userDetailsDto);

        Assertions.assertThat(testSubject.acceptInvitation(
                new InvitationAcceptDto(
                        1L,
                        1L
                )
        )).isEqualTo(new InvitationDetailsDto(
                1L,
                InvitationState.ACCEPTED,
                organizationDto,
                userDetailsDto
        ));

        verify(invitationService).findById(1L);
        verify(userService).update(new UpdateUserParams(
                1L,
                "u",
                "n",
                false
        ));
        verify(invitationService).update(new UpdateInvitationParams(
                1L,
                1L,
                1L,
                InvitationState.ACCEPTED
        ));
        verify(organizationMapper).map(organization);
        verify(userMapper).map(updatedUser);
        verifyNoMoreInteractions(
                invitationService,
                userService,
                organizationService,
                userMapper,
                organizationMapper
        );
    }

    @Test
    public void testRejectInvitationWhenInvitationNotFound() {
        when(invitationService.findById(1L))
                .thenReturn(Optional.empty());

        Assertions.assertThat(testSubject.rejectInvitation(
                new InvitationRejectDto(
                        1L,
                        1L
                )
        )).isEqualTo(new InvitationDetailsDto(List.of("Not found invitation with id - 1")));

        verify(invitationService).findById(1L);

        verifyNoMoreInteractions(
                invitationService,
                userService,
                organizationService,
                userMapper,
                organizationMapper
        );
    }

    @Test
    public void testRejectInvitationWhenUserNotFound() {
        final Organization organization = new Organization("n", LocalDate.of(1111, 11, 11));
        organization.setId(1L);
        final User user = new User("u", "n", true);
        user.setId(2L);
        final Invitation invitation = new Invitation(
                InvitationState.PENDING,
                organization,
                user
        );
        invitation.setId(1L);

        when(invitationService.findById(1L))
                .thenReturn(Optional.of(invitation));

        Assertions.assertThat(testSubject.rejectInvitation(
                new InvitationRejectDto(
                        1L,
                        1L
                )
        )).isEqualTo(new InvitationDetailsDto(List.of(
                "Not found invitation with id - 1 for user with id - 1"
        )));

        verify(invitationService).findById(1L);

        verifyNoMoreInteractions(
                invitationService,
                userService,
                organizationService,
                userMapper,
                organizationMapper
        );
    }

    @Test
    public void testRejectInvitation() {
        final Organization organization = new Organization("n", LocalDate.of(1111, 11, 11));
        organization.setId(1L);
        final User user = new User("u", "n", true);
        user.setId(1L);
        final Invitation invitation = new Invitation(
                InvitationState.PENDING,
                organization,
                user
        );
        invitation.setId(1L);

        when(invitationService.findById(1L))
                .thenReturn(Optional.of(invitation));

        final Invitation updatedInvitation = new Invitation(InvitationState.REJECTED, organization, user);
        updatedInvitation.setId(1L);
        when(invitationService.update(new UpdateInvitationParams(
                1L,
                1L,
                1L,
                InvitationState.REJECTED
        ))).thenReturn(updatedInvitation);

        final OrganizationDto organizationDto = new OrganizationDto(
                1L,
                "n",
                LocalDate.of(1111, 11, 11)
        );
        when(organizationMapper.map(organization))
                .thenReturn(organizationDto);

        final UserDetailsDto userDetailsDto = new UserDetailsDto(
                1L,
                "u",
                "n",
                false
        );
        when(userMapper.map(user))
                .thenReturn(userDetailsDto);


        Assertions.assertThat(testSubject.rejectInvitation(
                new InvitationRejectDto(
                        1L,
                        1L
                )
        )).isEqualTo(new InvitationDetailsDto(
                1L,
                InvitationState.REJECTED,
                organizationDto,
                userDetailsDto
        ));

        verify(invitationService).findById(1L);
        verify(invitationService).update(new UpdateInvitationParams(
                1L,
                1L,
                1L,
                InvitationState.REJECTED
        ));
        verify(organizationMapper).map(organization);
        verify(userMapper).map(user);
        verifyNoMoreInteractions(
                invitationService,
                userService,
                organizationService,
                userMapper,
                organizationMapper
        );
    }

}