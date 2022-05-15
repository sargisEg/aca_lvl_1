package com.aca.exam.exam3.repository;

import com.aca.exam.exam3.entity.NumberPlate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NumberPlateRepository extends JpaRepository<NumberPlate, Long> {

    Optional<NumberPlate> findByPlateNumber(String plateNumber);
}
