package com.aca.homework.week19.job.platform.service.core.invitation;

import com.aca.homework.week19.job.platform.entity.Invitation;

import java.util.Optional;

public interface InvitationService {

    Invitation create(CreateInvitationParams params);

    Invitation update(UpdateInvitationParams params);

    Optional<Invitation> findById(Long id);
}
