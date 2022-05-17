package com.aca.homework.week19.job.platform.facade.invitation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JobHireRequestDtoTest {

    @Test
    public void testWhenInvitationIdIsNull() {
        Assertions.assertThatThrownBy(() -> new JobHireRequestDto(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}