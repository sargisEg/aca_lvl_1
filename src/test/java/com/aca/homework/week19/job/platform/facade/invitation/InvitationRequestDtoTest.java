package com.aca.homework.week19.job.platform.facade.invitation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InvitationRequestDtoTest {

    @Test
    public void testWhenUserIdIsNull() {
        Assertions.assertThatThrownBy(() -> new InvitationRequestDto(null, 1L))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenOrganizationIdIsNull() {
        Assertions.assertThatThrownBy(() -> new InvitationRequestDto(1L, null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}