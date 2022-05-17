package com.aca.homework.week19.job.platform.facade.user;

import com.aca.homework.week19.job.platform.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserMapperImplTest {

    private UserMapper userMapper;

    @BeforeEach
    public void init() {
        userMapper = new UserMapperImpl();
    }

    @Test
    public void testMapWhenUserNull() {
        Assertions.assertThatThrownBy(() -> userMapper.map(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testMap() {
        final User user = new User("u", "n", false);
        user.setId(1L);
        final UserDetailsDto dto = new UserDetailsDto(1L, "u", "n", false);
        Assertions.assertThat(userMapper.map(user))
                .isEqualTo(dto);
    }
}