package com.aca.exam.exam3.service.core.user;

import com.aca.exam.exam3.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User create(CreateUserParams params);

    User getById(Long id);

    User getByPassportId(String passportId);
}
