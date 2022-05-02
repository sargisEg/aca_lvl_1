package com.aca.exam.exam3.facade;

import com.aca.exam.exam3.entity.NumberPlate;
import com.aca.exam.exam3.entity.User;
import com.aca.exam.exam3.entity.UserPlateNumber;
import com.aca.exam.exam3.service.core.number.plate.CreateNumberPlateParams;
import com.aca.exam.exam3.service.core.number.plate.NumberPlateService;
import com.aca.exam.exam3.service.core.user.UserService;
import com.aca.exam.exam3.service.core.users.plate.number.CreateUserPlateNumberParams;
import com.aca.exam.exam3.service.core.users.plate.number.UserPlateNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class UserPlateNumberFacadeImpl implements UserPlateNumberFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPlateNumberFacadeImpl.class);

    private final UserService userService;
    private final NumberPlateService numberPlateService;
    private final UserPlateNumberService userPlateNumberService;

    public UserPlateNumberFacadeImpl(
            UserService userService,
            NumberPlateService numberPlateService,
            UserPlateNumberService userPlateNumberService) {
        this.userService = userService;
        this.numberPlateService = numberPlateService;
        this.userPlateNumberService = userPlateNumberService;
    }

    @Override
    public UserTakePlateNumberResponseDto takePlateNumber(UserTakePlateNumberRequestDto dto) {

        final NumberPlate plateNumber = numberPlateService.getByPlateNumber(dto.getPlateNumber());

        final UserPlateNumber userPlateNumber = userPlateNumberService.getByNumberPlateId(plateNumber.getId());

        if (userPlateNumber != null) {
            throw new NumberTakenException(plateNumber.getPlateNumber());
        }

        final User user = userService.getByPassportId(dto.getPassword_id());

        userPlateNumberService.create(
                new CreateUserPlateNumberParams(user.getId(), plateNumber.getId())
        );

        return new UserTakePlateNumberResponseDto(plateNumber.getPlateNumber());
    }

    @Override
    public GetAllUserNumbersResponseDto getAllUserNumbers(GetAllUserNumbersRequestDto dto) {

        final User userByPassportId = userService.getByPassportId(dto.getPassportId());

        final List<UserPlateNumber> userPlateNumbers = userPlateNumberService.getByUserId(userByPassportId.getId());

        List<NumberPlate> plateNumbers = new LinkedList<>();

        userPlateNumbers.forEach(userPlateNumber -> {
            plateNumbers.add(userPlateNumber.getNumberPlate());
        });

        return new GetAllUserNumbersResponseDto(plateNumbers);
    }
}
