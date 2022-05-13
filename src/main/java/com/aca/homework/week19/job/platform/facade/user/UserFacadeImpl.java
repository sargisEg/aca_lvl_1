package com.aca.homework.week19.job.platform.facade.user;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.service.core.CreateUserParams;
import com.aca.homework.week19.job.platform.service.core.UpdateUserParams;
import com.aca.homework.week19.job.platform.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Component
public class UserFacadeImpl implements UserFacade {

    private static Logger LOGGER = LoggerFactory.getLogger(UserMapperImpl.class);

    private final UserService userService;
    private final UserMapper userMapper;

    public UserFacadeImpl(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetailsDto signUp(UserSignUpRequestDto dto) {
        Assert.notNull(
                dto,
                "Class - UserFacadeImpl, method - signUp(UserSignUpRequestDto dto) " +
                        "dto should not be null"
        );
        LOGGER.info("Signing up a user for provided request - {}", dto);

        final Optional<User> optionalUser = userService.findByUsername(dto.getUsername());

        if (optionalUser.isPresent()) {
            return new UserDetailsDto(List.of("User with username - " + dto.getUsername() + " already exist"));
        }

        final User user = userService.create(new CreateUserParams(
                dto.getUsername(),
                dto.getName(),
                false
        ));

        final UserDetailsDto responseDto = userMapper.map(user);

        LOGGER.info("Successfully signed up a user for provided request - {}, response - {}", dto, responseDto);
        return responseDto;
    }

    @Override
    public UserDetailsDto getUserDetails(Long userId) {
        Assert.notNull(
                userId,
                "Class - UserFacadeImpl, method - getUserDetails(Long userId) " +
                        "userId should not be null"
        );
        LOGGER.info("Getting user details for user with id - {}", userId);

        final Optional<User> optionalUser = userService.findById(userId);

        if (optionalUser.isEmpty()) {
            return new UserDetailsDto(List.of("User with id - " + userId + " does not exist"));
        }

        final UserDetailsDto userDetails = userMapper.map(optionalUser.get());

        LOGGER.info("Successfully got user details for user with id - {}, user details - {}", userId, userDetails);
        return userDetails;
    }

    @Override
    public UserDetailsDto openToWork(Long userId) {
        Assert.notNull(
                userId,
                "Class - UserFacadeImpl, method - openToWork(Long userId) " +
                        "userId should not be null"
        );
        LOGGER.info("Opening for offers user with id - {}", userId);

        final Optional<User> optionalUser = userService.findById(userId);

        if (optionalUser.isEmpty()) {
            return new UserDetailsDto(List.of("User with id - " + userId + " does not exist"));
        }

        final User user = optionalUser.get();

        if (user.isOpenForOffers()) {
            return new UserDetailsDto(List.of("User with id - " + userId + " already open for offers"));
        }

        final User updateUser = userService.update(new UpdateUserParams(
                user.getId(),
                user.getUsername(),
                user.getName(),
                true
        ));

        final UserDetailsDto userDetails = userMapper.map(updateUser);

        LOGGER.info("Successfully opened for offers user with id - {}, user details - {}", userId, userDetails);
        return userDetails;
    }
}
