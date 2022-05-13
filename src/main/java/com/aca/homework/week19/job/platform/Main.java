package com.aca.homework.week19.job.platform;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.user.UserFacade;
import com.aca.homework.week19.job.platform.facade.user.UserSignUpRequestDto;
import com.aca.homework.week19.job.platform.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Main {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        UserFacade userFacade = context.getBean(UserFacade.class);

        userFacade.signUp(new UserSignUpRequestDto(
                "username1",
                "name1"
        ));

        userFacade.signUp(new UserSignUpRequestDto(
                "username2",
                "name2"
        ));

        userFacade.signUp(new UserSignUpRequestDto(
                "username3",
                "name3"
        ));

        userFacade.getUserDetails(2L);

        userFacade.openToWork(3L);
        userFacade.openToWork(1L);
    }
}
