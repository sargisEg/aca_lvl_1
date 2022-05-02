package com.aca.exam.exam3;

import com.aca.exam.exam3.entity.NumberPlate;
import com.aca.exam.exam3.entity.User;
import com.aca.exam.exam3.entity.UserPlateNumber;
import com.aca.exam.exam3.facade.GetAllUserNumbersRequestDto;
import com.aca.exam.exam3.facade.UserPlateNumberFacade;
import com.aca.exam.exam3.facade.UserPlateNumberFacadeImpl;
import com.aca.exam.exam3.facade.UserTakePlateNumberRequestDto;
import com.aca.exam.exam3.repository.NumberPlateRepository;
import com.aca.exam.exam3.repository.UserPlateNumberRepository;
import com.aca.exam.exam3.repository.UserRepository;
import com.aca.exam.exam3.service.core.number.plate.CreateNumberPlateParams;
import com.aca.exam.exam3.service.core.number.plate.NumberPlateService;
import com.aca.exam.exam3.service.core.user.CreateUserParams;
import com.aca.exam.exam3.service.core.user.UserService;
import com.aca.exam.exam3.service.core.users.plate.number.CreateUserPlateNumberParams;
import com.aca.exam.exam3.service.core.users.plate.number.UserPlateNumberService;
import com.aca.exam.exam3.service.impl.number.plate.NumberPlateServiceImpl;
import com.aca.exam.exam3.service.impl.user.UserServiceImpl;
import com.aca.exam.exam3.service.impl.users.plate.number.UserPlateNumberImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableJpaRepositories
public class Main {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        NumberPlateRepository numberPlateRepository = context.getBean(NumberPlateRepository.class);
        UserPlateNumberRepository userPlateNumberRepository = context.getBean(UserPlateNumberRepository.class);

        UserService userService = new UserServiceImpl(userRepository);
        NumberPlateService numberPlateService = new NumberPlateServiceImpl(numberPlateRepository);
        UserPlateNumberService userPlateNumberService = new UserPlateNumberImpl(
                userPlateNumberRepository,
                userService,
                numberPlateService
        );

        UserPlateNumberFacade userPlateNumberFacade = new UserPlateNumberFacadeImpl(
                userService,
                numberPlateService,
                userPlateNumberService
        );

        final User user = userService.create(new CreateUserParams(123456L, "first", "Second"));
        final User user1 = userService.create(new CreateUserParams(654321L, "first4", "Second2"));

        final NumberPlate numberPlate = numberPlateService.create(new CreateNumberPlateParams("AC 123"));
        final NumberPlate numberPlate1 = numberPlateService.create(new CreateNumberPlateParams("AC 346"));
        final NumberPlate numberPlate2 = numberPlateService.create(new CreateNumberPlateParams("AC 951"));
        final NumberPlate numberPlate3 = numberPlateService.create(new CreateNumberPlateParams("AC 564"));
//
//        userPlateNumberFacade.takePlateNumber(new UserTakePlateNumberRequestDto(user.getPassportId(), numberPlate.getPlateNumber()));
//        userPlateNumberFacade.takePlateNumber(new UserTakePlateNumberRequestDto(user.getPassportId(), numberPlate2.getPlateNumber()));
//        userPlateNumberFacade.takePlateNumber(new UserTakePlateNumberRequestDto(user1.getPassportId(), numberPlate.getPlateNumber()));
//        userPlateNumberFacade.takePlateNumber(new UserTakePlateNumberRequestDto(user1.getPassportId(), numberPlate3.getPlateNumber()));
//
//        userPlateNumberFacade.getAllUserNumbers(new GetAllUserNumbersRequestDto(user1.getPassportId()));

        ExecutorService executorService = Executors.newFixedThreadPool(16);
        String[] letters = {"AA", "AB", "AC", "BA", "BB", "BC", "CA", "CB", "CC"};
        // TODO: 02/05/2022 Can be faster
        for (int i = 0; i < 9; i++) {
            int finalI = i;
            executorService.submit(() -> {
                generatePlateNumbersAndSave(numberPlateService, letters[finalI]);
            });
        }
        executorService.shutdown();
    }

    private static void generatePlateNumbersAndSave(NumberPlateService numberPlateService, String letters) {
        StringBuilder result;
        for (int j = 0; j < 1000; j++) {
            result = new StringBuilder(letters);
            if (j / 10 == 0) {
                result.append(" 00").append(j);
            } else if (j / 100 == 0) {
                result.append(" 0").append(j);
            } else {
                result.append(" ").append(j);
            }

            numberPlateService.create(new CreateNumberPlateParams(result.toString()));
        }

    }
}
