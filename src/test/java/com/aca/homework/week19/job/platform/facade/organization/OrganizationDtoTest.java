package com.aca.homework.week19.job.platform.facade.organization;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class OrganizationDtoTest {

    @Test
    public void testWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> new OrganizationDto(null, "name", LocalDate.now()))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenNameIsNull() {
        Assertions.assertThatThrownBy(() -> new OrganizationDto(12L, null, LocalDate.now()))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenCreationDateIsNull() {
        Assertions.assertThatThrownBy(() -> new OrganizationDto(12L, "name", null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenErrorsIsNull() {
        Assertions.assertThatThrownBy(() -> new OrganizationDto(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}