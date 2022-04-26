package com.aca.homework.week15.service.user;

import com.aca.homework.week15.log.LoggerMain;
import com.aca.homework.week15.service.user.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {

    private final UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserCreateParams params) {
        LOGGER.debug("Creating a user for the provided creation params - {}, {}", params.getUsername(), params.getName());
        User createdUser = new User(params.getUsername(), params.getName());
        userRepository.save(createdUser);
        LOGGER.debug("Successfully created a user for the provided creation params - {}, {} , result - {}", params.getUsername(), params.getName(), createdUser);
        return createdUser;
    }
}
