package com.aca.homework.week19.job.platform.facade.invitation;

import com.aca.homework.week19.job.platform.facade.organization.OrganizationDto;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class JobHireResponseDtoTest {

    @Test
    public void testWhenUserDetailsDtoIsNull() {
        Assertions.assertThatThrownBy(() -> new JobHireResponseDto(null, new OrganizationDto(List.of(""))))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenOrganizationDtoIsNull() {
        Assertions.assertThatThrownBy(() -> new JobHireResponseDto(new UserDetailsDto(List.of("")), null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenErrorIsNull() {
        Assertions.assertThatThrownBy(() -> new JobHireResponseDto(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}