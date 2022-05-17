package com.aca.homework.week19.job.platform.facade.invitation;

import com.aca.homework.week19.job.platform.entity.Invitation;
import com.aca.homework.week19.job.platform.entity.InvitationState;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationMapper;
import com.aca.homework.week19.job.platform.facade.user.UserMapper;
import com.aca.homework.week19.job.platform.service.core.invitation.CreateInvitationParams;
import com.aca.homework.week19.job.platform.service.core.invitation.InvitationService;
import com.aca.homework.week19.job.platform.service.core.invitation.UpdateInvitationParams;
import com.aca.homework.week19.job.platform.service.core.organization.CreateEmployerParams;
import com.aca.homework.week19.job.platform.service.core.organization.EmployeeService;
import com.aca.homework.week19.job.platform.service.core.organization.OrganizationService;
import com.aca.homework.week19.job.platform.service.core.user.UpdateUserParams;
import com.aca.homework.week19.job.platform.service.core.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Component
public class InvitationFacadeImpl implements InvitationFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvitationFacadeImpl.class);

    private final InvitationService invitationService;
    private final UserService userService;
    private final OrganizationService organizationService;
    private final OrganizationMapper organizationMapper;
    private final UserMapper userMapper;

    public InvitationFacadeImpl(InvitationService invitationService, UserService userService, OrganizationService organizationService, OrganizationMapper organizationMapper, UserMapper userMapper) {
        this.invitationService = invitationService;
        this.userService = userService;
        this.organizationService = organizationService;
        this.organizationMapper = organizationMapper;
        this.userMapper = userMapper;
    }

    @Override
    public InvitationDetailsDto sendInvitation(InvitationRequestDto dto) {
        Assert.notNull(
                dto,
                "Class - InvitationFacadeImpl, method - sendInvitation(InvitationRequestDto dto) " +
                        "dto should not be null"
        );
        LOGGER.info("Sending invitation for provided request - {}", dto);

        final Optional<User> optionalUser = userService.findById(dto.getUserId());

        if (optionalUser.isEmpty()) {
            return new InvitationDetailsDto(List.of("Not found user with id - " + dto.getUserId()));
        }

        if (!optionalUser.get().isOpenForOffers()) {
            return new InvitationDetailsDto(List.of("User with id - " + dto.getUserId() + " is not open for offers"));
        }

        final Optional<Organization> optionalOrganization = organizationService.findById(dto.getOrganizationId());

        if (optionalOrganization.isEmpty()) {
            return new InvitationDetailsDto(List.of("Not found organization with id - " + dto.getOrganizationId()));
        }

        final Invitation invitation = invitationService.create(new CreateInvitationParams(
                dto.getOrganizationId(),
                dto.getUserId(),
                InvitationState.PENDING
        ));

        final InvitationDetailsDto responseDto = new InvitationDetailsDto(
                invitation.getId(),
                invitation.getInvitationState(),
                organizationMapper.map(optionalOrganization.get()),
                userMapper.map(optionalUser.get())
        );

        LOGGER.info("Successfully send invitation for provided request - {}, response - {}", dto, responseDto);
        return responseDto;
    }

    @Override
    public InvitationDetailsDto acceptInvitation(InvitationAcceptDto dto) {
        Assert.notNull(
                dto,
                "Class - InvitationFacadeImpl, method - acceptInvitation(InvitationAcceptDto dto) " +
                        "dto should not be null"
        );
        LOGGER.info("Accepting invitation for provided request - {}", dto);

        final Optional<Invitation> optionalInvitation = invitationService.findById(dto.getInvitationId());

        if (optionalInvitation.isEmpty()) {
            return new InvitationDetailsDto(List.of("Not found invitation with id - " + dto.getInvitationId()));
        }

        final Invitation invitation = optionalInvitation.get();
        if (!invitation.getUser().getId().equals(dto.getUserId())) {
            return new InvitationDetailsDto(List.of("Not found invitation with id - " + dto.getInvitationId()
                    + " for user with id - " + dto.getUserId()));
        }

        final User user = invitation.getUser();
        final User updatedUser = userService.update(
                new UpdateUserParams(
                        user.getId(),
                        user.getUsername(),
                        user.getName(),
                        false
                )
        );
        final Invitation updatedInvitation = invitationService.update(
                new UpdateInvitationParams(
                        invitation.getId(),
                        invitation.getOrganization().getId(),
                        updatedUser.getId(),
                        InvitationState.ACCEPTED
                )
        );

        final InvitationDetailsDto responseDto = new InvitationDetailsDto(
                updatedInvitation.getId(),
                updatedInvitation.getInvitationState(),
                organizationMapper.map(updatedInvitation.getOrganization()),
                userMapper.map(updatedInvitation.getUser())
        );


        LOGGER.info("Successfully accepted invitation for provided request - {}, response - {}", dto, responseDto);
        return responseDto;
    }

    @Override
    public InvitationDetailsDto rejectInvitation(InvitationRejectDto dto) {
        Assert.notNull(
                dto,
                "Class - InvitationFacadeImpl, method - rejectInvitation(InvitationRejectDto dto) " +
                        "dto should not be null"
        );
        LOGGER.info("Rejecting invitation for provided request - {}", dto);

        final Optional<Invitation> optionalInvitation = invitationService.findById(dto.getInvitationId());

        if (optionalInvitation.isEmpty()) {
            return new InvitationDetailsDto(List.of("Not found invitation with id - " + dto.getInvitationId()));
        }

        final Invitation invitation = optionalInvitation.get();
        if (!invitation.getUser().getId().equals(dto.getUserId())) {
            return new InvitationDetailsDto(List.of("Not found invitation with id - " + dto.getInvitationId()
                    + " for user with id - " + dto.getUserId()));
        }

        final Invitation updatedInvitation = invitationService.update(
                new UpdateInvitationParams(
                        invitation.getId(),
                        invitation.getOrganization().getId(),
                        invitation.getUser().getId(),
                        InvitationState.REJECTED
                )
        );

        final InvitationDetailsDto responseDto = new InvitationDetailsDto(
                updatedInvitation.getId(),
                updatedInvitation.getInvitationState(),
                organizationMapper.map(updatedInvitation.getOrganization()),
                userMapper.map(updatedInvitation.getUser())
        );

        LOGGER.info("Successfully rejected invitation for provided request - {}, response - {}", dto, responseDto);
        return responseDto;
    }
}
