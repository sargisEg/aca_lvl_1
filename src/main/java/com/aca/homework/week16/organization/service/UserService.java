package com.aca.homework.week16.organization.service;

import com.aca.homework.week16.organization.User;
import com.aca.homework.week16.organization.create.params.UserCreateParams;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User create(UserCreateParams params);

    User getById(Long id);
}
