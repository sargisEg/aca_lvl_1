package com.aca.homework.week19.job.platform.facade.invitation;

public interface InvitationFacade {

    InvitationDetailsDto sendInvitation(InvitationRequestDto dto);

    InvitationDetailsDto acceptInvitation(InvitationAcceptDto dto);

    InvitationDetailsDto rejectInvitation(InvitationRejectDto dto);
}
