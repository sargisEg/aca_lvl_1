package com.aca.exam.exam3.facade;

import com.aca.exam.exam3.entity.NumberPlate;
import com.aca.exam.exam3.entity.User;
import com.aca.exam.exam3.entity.UserPlateNumber;
import com.aca.exam.exam3.service.core.number.plate.NumberPlateService;
import com.aca.exam.exam3.service.core.user.UserService;
import com.aca.exam.exam3.service.core.users.plate.number.CreateUserPlateNumberParams;
import com.aca.exam.exam3.service.core.users.plate.number.UserPlateNumberService;
import com.aca.exam.exam3.service.impl.user.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
        Assert.notNull(dto, "Take plate number request should not be null");
        LOGGER.info("Taking plate number for provided request - {}", dto);

        final NumberPlate plateNumber = numberPlateService.getByPlateNumber(dto.getPlateNumber());

        final Optional<UserPlateNumber> optionalUserPlateNumber = userPlateNumberService
                .findByNumberPlateId(plateNumber.getId());

        if (optionalUserPlateNumber.isPresent()) {
            throw new NumberTakenException(plateNumber.getPlateNumber());
        }

        final User user = userService.getByPassportId(dto.getPassportId());

        userPlateNumberService.create(
                new CreateUserPlateNumberParams(user.getId(), plateNumber.getId())
        );

        final UserTakePlateNumberResponseDto responseDto =
                new UserTakePlateNumberResponseDto(
                        plateNumber.getPlateNumber(),
                        user.getPassportId()
                );
        LOGGER.info("Successfully took plate number for provided request - {}, response - {}", dto, responseDto);
        return responseDto;
    }

    @Override
    public GetAllUserNumbersResponseDto getAllUserNumbers(GetAllUserNumbersRequestDto dto) {
        Assert.notNull(dto, "Get users all plate numbers request should not be null");
        LOGGER.info("Getting all plate numbers for provided request - {}", dto);

        final User userByPassportId = userService.getByPassportId(dto.getPassportId());

        final List<UserPlateNumber> userPlateNumbers = userPlateNumberService.getByUserId(userByPassportId.getId());

        List<NumberPlate> plateNumbers = new LinkedList<>();

        userPlateNumbers.forEach(userPlateNumber -> {
            plateNumbers.add(userPlateNumber.getNumberPlate());
        });

        final GetAllUserNumbersResponseDto responseDto = new GetAllUserNumbersResponseDto(plateNumbers);
        LOGGER.info("Successfully got all plate numbers for provided request - {}, response - {}", dto, responseDto);
        return responseDto;
    }
}
