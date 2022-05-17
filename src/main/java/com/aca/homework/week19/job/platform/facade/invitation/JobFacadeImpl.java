package com.aca.homework.week19.job.platform.facade.invitation;

import com.aca.homework.week19.job.platform.entity.Invitation;
import com.aca.homework.week19.job.platform.entity.InvitationState;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationMapper;
import com.aca.homework.week19.job.platform.facade.user.UserMapper;
import com.aca.homework.week19.job.platform.service.core.invitation.InvitationService;
import com.aca.homework.week19.job.platform.service.core.organization.CreateEmployerParams;
import com.aca.homework.week19.job.platform.service.core.organization.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Component
public class JobFacadeImpl implements JobFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobFacadeImpl.class);

    private final InvitationService invitationService;
    private final EmployeeService employeeService;
    private final OrganizationMapper organizationMapper;
    private final UserMapper userMapper;

    public JobFacadeImpl(InvitationService invitationService, EmployeeService employeeService, OrganizationMapper organizationMapper, UserMapper userMapper) {
        this.invitationService = invitationService;
        this.employeeService = employeeService;
        this.organizationMapper = organizationMapper;
        this.userMapper = userMapper;
    }

    @Override
    public JobHireResponseDto hire(JobHireRequestDto dto) {
        Assert.notNull(
                dto,
                "Class - JobFacadeImpl, method - hire(JobHireRequestDto dto) " +
                        "dto should not be null"
        );
        LOGGER.info("Hiring for a job for provided request - {}", dto);

        final Optional<Invitation> optionalInvitation = invitationService.findById(dto.getInvitationId());

        if (optionalInvitation.isEmpty()) {
            return new JobHireResponseDto(List.of("Not found invitation with id - " + dto.getInvitationId()));
        }

        if (!optionalInvitation.get().getInvitationState().equals(InvitationState.ACCEPTED)) {
            return new JobHireResponseDto(List.of("Invitation with id - " + dto.getInvitationId() + " is not accepted"));
        }

        final Invitation invitation = optionalInvitation.get();

        employeeService.create(new CreateEmployerParams(
                invitation.getUser().getId(),
                invitation.getOrganization().getId()
        ));

        final JobHireResponseDto responseDto = new JobHireResponseDto(
                userMapper.map(invitation.getUser()),
                organizationMapper.map(invitation.getOrganization())
        );

        LOGGER.info("Successfully hired for a job for provided request - {}, response - {}", dto, responseDto);
        return responseDto;
    }
}
