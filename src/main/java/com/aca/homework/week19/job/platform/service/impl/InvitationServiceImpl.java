package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Invitation;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.repository.InvitationRepository;
import com.aca.homework.week19.job.platform.service.core.invitation.CreateInvitationParams;
import com.aca.homework.week19.job.platform.service.core.invitation.InvitationService;
import com.aca.homework.week19.job.platform.service.core.invitation.UpdateInvitationParams;
import com.aca.homework.week19.job.platform.service.core.organization.OrganizationService;
import com.aca.homework.week19.job.platform.service.core.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class InvitationServiceImpl implements InvitationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvitationServiceImpl.class);

    private final InvitationRepository invitationRepository;
    private final UserService userService;
    private final OrganizationService organizationService;

    public InvitationServiceImpl(InvitationRepository invitationRepository, UserService userService, OrganizationService organizationService) {
        this.invitationRepository = invitationRepository;
        this.userService = userService;
        this.organizationService = organizationService;
    }

    @Override
    public Invitation create(CreateInvitationParams params) {
        Assert.notNull(
                params,
                "Class - InvitationServiceImpl, method - create(CreateInvitationParams params) " +
                        "params should not be null"
        );
        LOGGER.info("Creating invitation with params - {}", params);

        final Organization organization = organizationService.findById(params.getOrganizationId())
                .orElseThrow(() -> {
                    throw new OrganizationNotFoundException(params.getOrganizationId());
                });

        final User user = userService.findById(params.getUserId())
                .orElseThrow(() -> {
                    throw new UserNotFoundException(params.getUserId());
                });

        final Invitation invitationFromParams = new Invitation(
                params.getInvitationState(),
                organization,
                user
        );

        final Invitation invitation = invitationRepository.save(invitationFromParams);

        LOGGER.info("Successfully created invitation with params - {}, result - {}", params, invitation);
        return invitation;
    }

    @Override
    public Optional<Invitation> findById(Long id) {
        Assert.notNull(
                id,
                "Class - InvitationServiceImpl, method - findById(Long id) " +
                        "id should not be null"
        );
        LOGGER.info("Finding invitation with id - {}", id);

        final Optional<Invitation> optionalInvitation = invitationRepository.findById(id);

        LOGGER.info("Successfully found invitation with id - {}, result - {}", id, optionalInvitation);
        return optionalInvitation;
    }

    @Override
    public Invitation update(UpdateInvitationParams params) {
        Assert.notNull(
                params,
                "Class - InvitationServiceImpl, method - update(UpdateInvitationParams params) " +
                        "params should not be null"
        );
        LOGGER.info("Updating invitation with params - {}", params);

        final Organization organization = organizationService.findById(params.getOrganizationId())
                .orElseThrow(() -> {
                    throw new OrganizationNotFoundException(params.getOrganizationId());
                });

        final User user = userService.findById(params.getUserId())
                .orElseThrow(() -> {
                    throw new UserNotFoundException(params.getUserId());
                });

        final Invitation invitationFromParams = new Invitation(
                params.getInvitationState(),
                organization,
                user
        );

        invitationFromParams.setId(params.getId());

        final Invitation invitation = invitationRepository.save(invitationFromParams);

        LOGGER.info("Successfully updated invitation with params - {}, result - {}", params, invitation);
        return invitation;
    }
}
