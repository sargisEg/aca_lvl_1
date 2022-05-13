package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.repository.UserRepository;
import com.aca.homework.week19.job.platform.service.core.CreateUserParams;
import com.aca.homework.week19.job.platform.service.core.UpdateUserParams;
import com.aca.homework.week19.job.platform.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(CreateUserParams params) {
        Assert.notNull(
                params,
                "Class - UserServiceImpl, method - create(CreateUserParams params) params should not be null"
        );
        LOGGER.info("Creating user with params - {}", params);

        final User userFromParams = new User(
                params.getUsername(),
                params.getName(),
                params.isOpenForOffers()
        );

        final User user = userRepository.save(userFromParams);

        LOGGER.info("Successfully created user with params - {}, result - {}", params, user);
        return user;
    }

    @Override
    public User update(UpdateUserParams params) {
        Assert.notNull(
                params,
                "Class - UserServiceImpl, method - update(UpdateUserParams params) " +
                        "params should not be null"
        );
        LOGGER.info("Updating user with params - {}", params);

        final User userFromParams = new User(
                params.getUsername(),
                params.getName(),
                params.isOpenForOffers()
        );
        userFromParams.setId(params.getId());

        final User user = userRepository.save(userFromParams);

        LOGGER.info("Successfully updated user with params - {}, result - {}", params, user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        Assert.notNull(
                id,
                "Class - UserServiceImpl, method - findById(Long id) id should not be null"
        );
        LOGGER.info("Finding user with id - {}", id);

        final Optional<User> optionalUser = userRepository.findById(id);

        LOGGER.info("Successfully found user with id - {}, result - {}", id, optionalUser);
        return optionalUser;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Assert.hasText(
                username,
                "Class - UserServiceImpl, method - findByUsername(String username) username should not be null or empty"
        );
        LOGGER.info("Finding user with username - {}", username);

        final Optional<User> optionalUser = userRepository.findByUsername(username);

        LOGGER.info("Successfully found user with username - {}, result - {}", username, optionalUser);
        return optionalUser;
    }
}
