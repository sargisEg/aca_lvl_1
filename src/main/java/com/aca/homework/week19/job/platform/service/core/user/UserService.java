package com.aca.homework.week19.job.platform.service.core.user;

import com.aca.homework.week19.job.platform.entity.User;

import java.util.Optional;

public interface UserService {

    User create(CreateUserParams params);

    User update(UpdateUserParams params);

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);
}
