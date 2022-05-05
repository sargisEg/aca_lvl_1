package com.aca.exam.exam3.service.impl.number.plate;

import com.aca.exam.exam3.entity.NumberPlate;
import com.aca.exam.exam3.entity.User;
import com.aca.exam.exam3.repository.NumberPlateRepository;
import com.aca.exam.exam3.service.core.number.plate.CreateNumberPlateParams;
import com.aca.exam.exam3.service.core.number.plate.NumberPlateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class NumberPlateServiceImpl implements NumberPlateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberPlateServiceImpl.class);

    private final NumberPlateRepository numberPlateRepository;

    public NumberPlateServiceImpl(NumberPlateRepository numberPlateRepository) {
        this.numberPlateRepository = numberPlateRepository;
    }

    @Override
    public NumberPlate create(CreateNumberPlateParams params) {
        Assert.notNull(params, "Number plate creation params should not be null");
        LOGGER.info("Creating plate number with providing params - {}", params);

        final NumberPlate numberPlateFromParams = new NumberPlate(params.getPlateNumber());

        final NumberPlate numberPlate = numberPlateRepository.save(numberPlateFromParams);

        LOGGER.info("Successfully created plate number with providing params - {}, result - {}", params, numberPlate);
        return numberPlate;
    }

    @Override
    public NumberPlate getById(Long id) {
        Assert.notNull(id, "Plate number id should not be null");
        LOGGER.info("Getting plate number with id - {}", id);

        final NumberPlate numberPlate = numberPlateRepository.findById(id)
                .orElseThrow(() -> {
                    throw new PlateNumberNotFoundException(id);
                });

        LOGGER.info("Successfully got plate number with id - {}, plate number - {}", id, numberPlate);
        return numberPlate;
    }

    @Override
    public NumberPlate getByPlateNumber(String plateNumber) {
        Assert.notNull(plateNumber, "Plate number should not be null");
        LOGGER.info("Getting plate number - {}", plateNumber);

        final NumberPlate numberPlate = numberPlateRepository.findByPlateNumber(plateNumber)
                .orElseThrow(() -> {
                    throw new PlateNumberNotFoundException(plateNumber);
                });

        LOGGER.info("Successfully got plate number - {}, plate number - {}", plateNumber, numberPlate);
        return numberPlate;
    }
}
