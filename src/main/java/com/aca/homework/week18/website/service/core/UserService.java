package com.aca.homework.week18.website.service.core;

import com.aca.homework.week18.website.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    User create(CreateUserParams params);

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

}
