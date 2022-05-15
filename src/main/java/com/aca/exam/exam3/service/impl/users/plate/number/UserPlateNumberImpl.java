package com.aca.exam.exam3.service.impl.users.plate.number;

import com.aca.exam.exam3.entity.NumberPlate;
import com.aca.exam.exam3.entity.User;
import com.aca.exam.exam3.entity.UserPlateNumber;
import com.aca.exam.exam3.repository.UserPlateNumberRepository;
import com.aca.exam.exam3.service.core.number.plate.NumberPlateService;
import com.aca.exam.exam3.service.core.user.UserService;
import com.aca.exam.exam3.service.core.users.plate.number.CreateUserPlateNumberParams;
import com.aca.exam.exam3.service.core.users.plate.number.UserPlateNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

public class UserPlateNumberImpl implements UserPlateNumberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPlateNumberImpl.class);

    private final UserPlateNumberRepository userPlateNumberRepository;
    private final UserService userService;
    private final NumberPlateService numberPlateService;

    public UserPlateNumberImpl(
            UserPlateNumberRepository userPlateNumberRepository,
            UserService userService,
            NumberPlateService numberPlateService) {

        this.userPlateNumberRepository = userPlateNumberRepository;
        this.userService = userService;
        this.numberPlateService = numberPlateService;
    }

    @Override
    public UserPlateNumber create(CreateUserPlateNumberParams params) {
        Assert.notNull(params, "User plate number creation params should not be null");
        LOGGER.info("Creating user plate number with params - {}", params);

        final User user = userService.getById(params.getUserId());

        final NumberPlate numberPlate = numberPlateService.getById(params.getNumberPlateId());

        final UserPlateNumber userPlateNumber = userPlateNumberRepository.save(
                new UserPlateNumber(user, numberPlate)
        );

        LOGGER.info("Successfully created user plate number with params - {}, result - {}", params, userPlateNumber);
        return userPlateNumber;
    }

    @Override
    public List<UserPlateNumber> getByUserId(Long id) {
        Assert.notNull(id, "User id should not be null");
        LOGGER.info("Getting User plate numbers for user with id - {}", id);

        final List<UserPlateNumber> userPlateNumberList = userPlateNumberRepository
                .findByUserId(id);

        LOGGER.info("Successfully got User plate numbers for user with id - {}, result - {}", id, userPlateNumberList);
        return userPlateNumberList;
    }

    @Override
    public UserPlateNumber getByNumberPlateId(Long id) {
        Assert.notNull(id, "Number plate id should not be null");
        LOGGER.info("Getting User plate numbers with number plate id - {}", id);

        final Optional<UserPlateNumber> numberPlate = userPlateNumberRepository
                .findByNumberPlateId(id);

        if (numberPlate.isEmpty()) {
            throw new UserPlateNumberNotFoundException(id);
        }

        final UserPlateNumber userPlateNumber = numberPlate.get();

        LOGGER.info("Successfully got User plate number with number plate  id - {}, result - {}", id, userPlateNumber);
        return userPlateNumber;
    }

    @Override
    public Optional<UserPlateNumber> findByNumberPlateId(Long id) {
        Assert.notNull(id, "Number plate id should not be null");
        LOGGER.info("Getting User plate numbers with number plate id - {}", id);

        final Optional<UserPlateNumber> optionalUserPlateNumber = userPlateNumberRepository
                .findByNumberPlateId(id);

        LOGGER.info(
                "Successfully got User plate number with number plate  id - {}, result - {}",
                id,
                optionalUserPlateNumber
        );
        return optionalUserPlateNumber;
    }
}
