package com.aca.homework.week18.website.service.impl;

import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.repository.UserRepository;
import com.aca.homework.week18.website.service.core.CreateUserParams;
import com.aca.homework.week18.website.service.core.UserService;
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
    public User create(CreateUserParams params) {
        Assert.notNull(params, "User creation params should not be null");
        LOGGER.info("Creating user with provided params - {}", params);

        final User userFromParams = new User(
                params.getUsername(),
                params.getFirstName(),
                params.getSecondName()
        );

        final User user = userRepository.save(userFromParams);

        LOGGER.info(
                "Successfully created user with provided params - {}, result - {}",
                params,
                user
        );
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        Assert.notNull(id, "User id should not be null");
        LOGGER.info("Finding user with id - {}", id);

        final Optional<User> optionalUser = userRepository.findById(id);

        LOGGER.info("Successfully found user with id - {}, result - {}", id, optionalUser);
        return optionalUser;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Assert.hasText(username, "Username should not be null or empty");
        LOGGER.info("Finding user with username - {}", username);

        final Optional<User> optionalUser = userRepository.findByUsername(username);

        LOGGER.info("Successfully found user with username - {}, result - {}", username, optionalUser);
        return optionalUser;
    }
}
