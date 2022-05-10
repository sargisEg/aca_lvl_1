package com.aca.homework.week17.note.facade.user;

import com.aca.homework.week17.note.entity.User;
import com.aca.homework.week17.note.facade.note.NoteFacadeImpl;
import com.aca.homework.week17.note.service.core.CreateUserParams;
import com.aca.homework.week17.note.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class UserFacadeImpl implements UserFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoteFacadeImpl.class);

    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserSignUpResponseDto signUp(UserSignUpRequestDto dto) {
        Assert.notNull(dto, "Request should not be null");
        LOGGER.info("Sign up user for the request - {}", dto);

        final User user = userService.create(new CreateUserParams(
                        dto.getUsername(),
                        dto.getFirstName(),
                        dto.getSecondName()
                )
        );

        final UserSignUpResponseDto responseDto = new UserSignUpResponseDto(user.getUsername());

        LOGGER.info("Successfully signed up user for the request - {}, response - {}", dto, responseDto);
        return responseDto;
    }
}
