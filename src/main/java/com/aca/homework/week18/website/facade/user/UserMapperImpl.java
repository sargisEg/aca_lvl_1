package com.aca.homework.week18.website.facade.user;

import com.aca.homework.week18.website.entity.User;

public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto map(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getSecondName()
        );
    }
}
