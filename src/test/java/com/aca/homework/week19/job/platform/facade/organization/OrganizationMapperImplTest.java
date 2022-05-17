package com.aca.homework.week19.job.platform.facade.organization;

import com.aca.homework.week19.job.platform.entity.Organization;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class OrganizationMapperImplTest {

    private OrganizationMapper testSubject;

    @BeforeEach
    public void init() {
        testSubject = new OrganizationMapperImpl();
    }

    @Test
    public void testWhenOrganizationIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.map(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testMap() {
        final Organization organization = new Organization("name", LocalDate.of(2001, 12, 12));
        organization.setId(1L);
        Assertions.assertThat(testSubject.map(organization))
                .isEqualTo(new OrganizationDto(1L, "name", LocalDate.of(2001, 12, 12)));
    }
}