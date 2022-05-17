package com.aca.homework.week19.job.platform.facade.invitation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InvitationAcceptDtoTest {

    @Test
    public void testWhenUserIdIsNull() {
        Assertions.assertThatThrownBy(() -> new InvitationAcceptDto(null, 1L))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenInvitationIdIsNull() {
        Assertions.assertThatThrownBy(() -> new InvitationAcceptDto(1L, null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}