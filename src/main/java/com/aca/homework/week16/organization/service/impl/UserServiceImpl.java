package com.aca.homework.week16.organization.service.impl;

import com.aca.homework.week16.organization.User;
import com.aca.homework.week16.organization.create.params.UserCreateParams;
import com.aca.homework.week16.organization.exception.UserNotFoundException;
import com.aca.homework.week16.organization.repository.UserRepository;
import com.aca.homework.week16.organization.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(UserCreateParams params) {
        Assert.notNull(params, "params should not be null");
        LOGGER.info("Creating User for params - {}", params);

        final User user = userRepository.save(new User(params.getFirst_name(), params.getSecond_name()));

        LOGGER.info("Successfully created User for params - {} result - {}", params, user);
        return user;
    }

    @Override
    public User getById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("Getting User with id - {}", id);

        final Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException(id);
        }

        final User user = optionalUser.get();

        LOGGER.info("Successfully got User with id - {} result - {}", id, user);
        return user;
    }
}
