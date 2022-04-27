package com.aca.homework.week16.organization;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrganizationCreateParamsTest {

    @Test
    public void testWhenNameIsNull() {
        Assertions.assertThatThrownBy(() -> new OrganizationCreateParams(null, "full"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenFullAddressIsNull() {
        Assertions.assertThatThrownBy(() -> new OrganizationCreateParams("name", null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}