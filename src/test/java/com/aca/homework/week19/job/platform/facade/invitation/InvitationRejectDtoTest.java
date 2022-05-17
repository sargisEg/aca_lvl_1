package com.aca.homework.week19.job.platform.facade.invitation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InvitationRejectDtoTest {

    @Test
    public void testWhenUserIdIsNull() {
        Assertions.assertThatThrownBy(() -> new InvitationRejectDto(null, 1L))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenInvitationIdIsNull() {
        Assertions.assertThatThrownBy(() -> new InvitationRejectDto(1L, null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}