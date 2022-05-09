package com.aca.homework.week18.website.facade.user;

import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.service.core.CreateUserParams;
import com.aca.homework.week18.website.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Optional;

public class UserFacadeImpl implements UserFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFacadeImpl.class);

    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserSignUpResponseDto signUp(UserSignUpRequestDto dto) {
        Assert.notNull(dto, "User signUp request dto should not be null");
        LOGGER.info("Signing up a user with a provided request - {}", dto);

        final String username = dto.getUsername();

        final Optional<User> optionalUser = userService.findByUsername(username);

        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistException(username);
        }

        final User user = userService.create(
                new CreateUserParams(
                        username,
                        dto.getFirstName(),
                        dto.getSecondName()
                )
        );

        final UserSignUpResponseDto responseDto = new UserSignUpResponseDto(
                user.getId(),
                user.getUsername()
        );

        LOGGER.info(
                "Successfully signed up a user with a provided request - {}, response - {}",
                dto,
                responseDto
        );
        return responseDto;
    }
}
