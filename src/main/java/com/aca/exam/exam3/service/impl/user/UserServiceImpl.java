package com.aca.exam.exam3.service.impl.user;

import com.aca.exam.exam3.entity.User;
import com.aca.exam.exam3.repository.UserRepository;
import com.aca.exam.exam3.service.core.user.CreateUserParams;
import com.aca.exam.exam3.service.core.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(CreateUserParams params) {
        Assert.notNull(params, "User creation params should not be null");
        LOGGER.info("Creating user with providing params - {}", params);

        final User userFromParams = new User(
                params.getPassportId(),
                params.getFirstName(),
                params.getSecondName()
        );

        final User user = userRepository.save(userFromParams);

        LOGGER.info("Successfully created user with providing params - {}, result - {}", params, user);
        return user;
    }

    @Override
    public User getById(Long id) {
        Assert.notNull(id, "User id should not be null");
        LOGGER.info("Getting user with id - {}", id);

        final User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    throw new UserNotFoundException(id);
                });

        LOGGER.info("Successfully got user with id - {}, user - {}", id, user);
        return user;
    }

    @Override
    public User getByPassportId(String passportId) {
        Assert.hasText(passportId, "User passport id should not be null or empty");
        LOGGER.info("Getting user with passport id - {}", passportId);

        final User user = userRepository.findByPassportId(passportId)
                .orElseThrow(() -> {
                    throw new UserNotFoundException(passportId);
                });

        LOGGER.info("Successfully got user with passport id - {}, user - {}", passportId, user);
        return user;
    }
}
