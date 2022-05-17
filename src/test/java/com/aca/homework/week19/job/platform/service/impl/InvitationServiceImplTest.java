package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Invitation;
import com.aca.homework.week19.job.platform.entity.InvitationState;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.repository.InvitationRepository;
import com.aca.homework.week19.job.platform.service.core.invitation.CreateInvitationParams;
import com.aca.homework.week19.job.platform.service.core.invitation.InvitationService;
import com.aca.homework.week19.job.platform.service.core.invitation.UpdateInvitationParams;
import com.aca.homework.week19.job.platform.service.core.organization.OrganizationService;
import com.aca.homework.week19.job.platform.service.core.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InvitationServiceImplTest {

    private InvitationService testSubject;

    @Mock
    private InvitationRepository invitationRepository;

    @Mock
    private UserService userService;

    @Mock
    private OrganizationService organizationService;

    @BeforeEach
    public void init() {
        testSubject = new InvitationServiceImpl(
                invitationRepository,
                userService,
                organizationService
        );
    }

    @Test
    public void testCreateWhenParamsIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.create(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testUpdateWhenParamsIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.update(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testFindByIdWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.findById(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCreateWhenOrganizationNotFound() {
        when(organizationService.findById(1L))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() ->
                testSubject.create(
                        new CreateInvitationParams(
                                1L,
                                1L,
                                InvitationState.PENDING
                        ))
        ).isExactlyInstanceOf(OrganizationNotFoundException.class);

        verify(organizationService).findById(1L);
        verifyNoMoreInteractions(organizationService, userService, invitationRepository);
    }

    @Test
    public void testCreateWhenUserNotFound() {
        when(organizationService.findById(1L))
                .thenReturn(Optional.of(new Organization()));

        when(userService.findById(1L))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() ->
                testSubject.create(
                        new CreateInvitationParams(
                                1L,
                                1L,
                                InvitationState.PENDING
                        ))
        ).isExactlyInstanceOf(UserNotFoundException.class);

        verify(organizationService).findById(1L);
        verify(userService).findById(1L);
        verifyNoMoreInteractions(organizationService, userService, invitationRepository);
    }

    @Test
    public void testCreate() {
        when(organizationService.findById(1L))
                .thenReturn(Optional.of(new Organization()));

        when(userService.findById(1L))
                .thenReturn(Optional.of(new User()));


        final Invitation invitation = new Invitation(
                InvitationState.ACCEPTED,
                new Organization(),
                new User()
        );
        invitation.setId(1L);

        when(invitationRepository.save(
                        new Invitation(
                                InvitationState.ACCEPTED,
                                new Organization(),
                                new User()
                        )
                )
        ).thenReturn(invitation);

        Assertions.assertThat(testSubject.create(
                new CreateInvitationParams(
                        1L,
                        1L,
                        InvitationState.ACCEPTED
                )
        )).isEqualTo(invitation);

        verify(organizationService).findById(1L);
        verify(userService).findById(1L);
        verify(invitationRepository).save(new Invitation(
                        InvitationState.ACCEPTED,
                        new Organization(),
                        new User()
                )
        );
        verifyNoMoreInteractions(organizationService, userService, invitationRepository);
    }

    @Test
    public void testFindById() {
        when(invitationRepository.findById(1L))
                .thenReturn(Optional.of(new Invitation()));

        Assertions.assertThat(testSubject.findById(1L))
                .isEqualTo(Optional.of(new Invitation()));

        verify(invitationRepository).findById(1L);
        verifyNoMoreInteractions(invitationRepository, userService, organizationService);
    }

    @Test
    public void testUpdateWhenOrganizationNotFound() {
        when(organizationService.findById(1L))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() ->
                testSubject.update(
                        new UpdateInvitationParams(
                                1L,
                                1L,
                                1L,
                                InvitationState.PENDING
                        ))
        ).isExactlyInstanceOf(OrganizationNotFoundException.class);

        verify(organizationService).findById(1L);
        verifyNoMoreInteractions(organizationService, userService, invitationRepository);
    }

    @Test
    public void testUpdateWhenUserNotFound() {
        when(organizationService.findById(1L))
                .thenReturn(Optional.of(new Organization()));

        when(userService.findById(1L))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() ->
                testSubject.update(
                        new UpdateInvitationParams(
                                1L,
                                1L,
                                1L,
                                InvitationState.PENDING
                        ))
        ).isExactlyInstanceOf(UserNotFoundException.class);

        verify(organizationService).findById(1L);
        verify(userService).findById(1L);
        verifyNoMoreInteractions(organizationService, userService, invitationRepository);
    }

    @Test
    public void testUpdate() {
        when(organizationService.findById(1L))
                .thenReturn(Optional.of(new Organization()));

        when(userService.findById(1L))
                .thenReturn(Optional.of(new User()));


        final Invitation invitation = new Invitation(
                InvitationState.ACCEPTED,
                new Organization(),
                new User()
        );
        invitation.setId(1L);

        when(invitationRepository.save(invitation))
                .thenReturn(invitation);

        Assertions.assertThat(testSubject.update(
                new UpdateInvitationParams(
                        1L,
                        1L,
                        1L,
                        InvitationState.ACCEPTED
                )
        )).isEqualTo(invitation);

        verify(organizationService).findById(1L);
        verify(userService).findById(1L);
        final Invitation entity = new Invitation(
                InvitationState.ACCEPTED,
                new Organization(),
                new User()
        );
        entity.setId(1L);
        verify(invitationRepository).save(entity);
        verifyNoMoreInteractions(organizationService, userService, invitationRepository);
    }

}