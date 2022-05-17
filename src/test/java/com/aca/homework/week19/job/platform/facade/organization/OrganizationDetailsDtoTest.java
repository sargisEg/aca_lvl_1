package com.aca.homework.week19.job.platform.facade.organization;

import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class OrganizationDetailsDtoTest {

    @Test
    public void testWhenErrorsIsNull() {
        Assertions.assertThatThrownBy(() -> new OrganizationDetailsDto(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenOrganizationDtoIsNull() {
        Assertions.assertThatThrownBy(() -> new OrganizationDetailsDto(null, Collections.emptyList()))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenUserDetailsDtoIsNull() {
        Assertions.assertThatThrownBy(() -> new OrganizationDetailsDto(new OrganizationDto(List.of("")), null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}