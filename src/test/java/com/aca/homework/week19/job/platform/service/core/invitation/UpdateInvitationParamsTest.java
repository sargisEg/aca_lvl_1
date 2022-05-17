package com.aca.homework.week19.job.platform.service.core.invitation;

import com.aca.homework.week19.job.platform.entity.InvitationState;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UpdateInvitationParamsTest {

    @Test
    public void testWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> new UpdateInvitationParams(
                null,
                1L,
                1L,
                InvitationState.ACCEPTED
        )).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenOrganizationIdIsNull() {
        Assertions.assertThatThrownBy(() -> new UpdateInvitationParams(
                1L,
                null,
                1L,
                InvitationState.ACCEPTED
        )).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenUserIdIsNull() {
        Assertions.assertThatThrownBy(() -> new UpdateInvitationParams(
                1L,
                1L,
                null,
                InvitationState.ACCEPTED
        )).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenInvitationStateIsNull() {
        Assertions.assertThatThrownBy(() -> new UpdateInvitationParams(
                1L,
                1L,
                1L,
                null
        )).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}