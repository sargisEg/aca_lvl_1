package com.aca.homework.week19.job.platform.facade.user;

import com.aca.homework.week19.job.platform.entity.User;

public interface UserMapper {

    UserDetailsDto map(User user);
}
