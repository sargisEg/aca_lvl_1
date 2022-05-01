package com.aca.homework.week17.note.service.impl;

import com.aca.homework.week17.note.entity.User;
import com.aca.homework.week17.note.repository.UserRepository;
import com.aca.homework.week17.note.service.core.CreateUserParams;
import com.aca.homework.week17.note.service.core.UserService;
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
        Assert.notNull(params, "Params should not be null");
        LOGGER.info("Creating a User with params - {}", params);

        final User userFromParams = new User(
                params.getUsername(),
                params.getFirstName(),
                params.getSecondName()
        );

        final User user = userRepository.save(userFromParams);

        LOGGER.info("Successfully Created a User with params - {}, result - {}", params, user);
        return user;
    }

    @Override
    public User getById(Long id) {
        Assert.notNull(id, "Id should not be null");
        LOGGER.info("Getting User with id - {}", id);

        final Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException(id);
        }

        final User user = optionalUser.get();

        LOGGER.info("Successfully got User with id - {}, result - {}", id, user);
        return user;
    }

    @Override
    public User getByUsername(String username) {
        Assert.hasText(username, "Username should not be null or empty");
        LOGGER.info("Getting User with username - {}", username);

        final Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException(username);
        }

        final User user = optionalUser.get();

        LOGGER.info("Successfully got User with username - {}, result - {}", username, user);
        return user;}
}
