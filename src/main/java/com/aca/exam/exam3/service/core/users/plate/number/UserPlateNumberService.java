package com.aca.exam.exam3.service.core.users.plate.number;

import com.aca.exam.exam3.entity.NumberPlate;
import com.aca.exam.exam3.entity.User;
import com.aca.exam.exam3.entity.UserPlateNumber;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserPlateNumberService {

    UserPlateNumber create(CreateUserPlateNumberParams params);

    List<UserPlateNumber> getByUserId(Long id);

    UserPlateNumber getByNumberPlateId(Long id);
}
