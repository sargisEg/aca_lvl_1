package com.aca.homework.week19.job.platform.service.core.organization;

import com.aca.homework.week19.job.platform.service.core.organization.CreateEmployerParams;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateEmployeeParamsTest {

    @Test
    public void testWhenUserIdIsNull() {
        Assertions.assertThatThrownBy(() -> new CreateEmployerParams(null, 1L))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenOrganizationIdIsNull() {
        Assertions.assertThatThrownBy(() -> new CreateEmployerParams(1L, null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}