package com.aca.homework.week19.job.platform.facade.user;

import com.aca.homework.week19.job.platform.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserMapperImpl implements UserMapper {

    private static Logger LOGGER = LoggerFactory.getLogger(UserMapperImpl.class);

    @Override
    public UserDetailsDto map(User user) {
        Assert.notNull(
                user,
                "Class - UserMapperImpl, method - map(User user) " +
                        "user should not be null"
        );
        LOGGER.debug("Mapping User to UserDetailsDto User - {}", user);
        final UserDetailsDto dto = new UserDetailsDto(user.getId(), user.getUsername(), user.getName(), user.isOpenForOffers());
        LOGGER.debug("Successfully mapped User to UserDetailsDto User - {}, dto - {}", user, dto);
        return dto;
    }
}
