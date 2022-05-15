package com.aca.exam.exam3.service.core.number.plate;

import com.aca.exam.exam3.entity.NumberPlate;
import org.springframework.stereotype.Service;

@Service
public interface NumberPlateService {

    NumberPlate create(CreateNumberPlateParams params);

    NumberPlate getById(Long id);

    NumberPlate getByPlateNumber(String plateNumber);
}
