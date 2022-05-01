package com.aca.homework.week17.note.service.core;

import com.aca.homework.week17.note.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User create(CreateUserParams params);

    User getById(Long id);

    User getByUsername(String username);
}
