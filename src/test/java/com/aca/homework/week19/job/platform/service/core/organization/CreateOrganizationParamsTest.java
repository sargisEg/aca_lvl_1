package com.aca.homework.week19.job.platform.service.core.organization;

import com.aca.homework.week19.job.platform.service.core.organization.CreateOrganizationParams;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CreateOrganizationParamsTest {

    @Test
    public void testWhenNameIsNull() {
        Assertions.assertThatThrownBy(() -> new CreateOrganizationParams(null, LocalDate.now()))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenCreationDateIsNull() {
        Assertions.assertThatThrownBy(() -> new CreateOrganizationParams("name", null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}