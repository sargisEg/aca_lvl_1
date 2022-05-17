package com.aca.homework.week19.job.platform.facade.organization;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrganizationRegistrationRequestDtoTest {

    @Test
    public void testWhenNameIsNull() {
        Assertions.assertThatThrownBy(() -> new OrganizationRegistrationRequestDto(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}