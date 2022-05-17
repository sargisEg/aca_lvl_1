package com.aca.homework.week19.job.platform.service.core.invitation;

import com.aca.homework.week19.job.platform.entity.InvitationState;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateInvitationParamsTest {

    @Test
    public void testWhenOrganizationIdIsNull() {
        Assertions.assertThatThrownBy(() -> new CreateInvitationParams(null, 1L, InvitationState.ACCEPTED))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenUserIdIsNull() {
        Assertions.assertThatThrownBy(() -> new CreateInvitationParams(1L, null, InvitationState.ACCEPTED))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenInvitationStateIsNull() {
        Assertions.assertThatThrownBy(() -> new CreateInvitationParams(1L, 1L, null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}