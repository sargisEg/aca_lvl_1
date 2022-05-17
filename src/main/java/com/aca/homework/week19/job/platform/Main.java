package com.aca.homework.week19.job.platform;

import com.aca.homework.week19.job.platform.facade.invitation.*;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationFacade;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationRegistrationRequestDto;
import com.aca.homework.week19.job.platform.facade.user.UserFacade;
import com.aca.homework.week19.job.platform.facade.user.UserSignUpRequestDto;
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
        OrganizationFacade organizationFacade = context.getBean(OrganizationFacade.class);
        InvitationFacade invitationFacade = context.getBean(InvitationFacade.class);
        JobFacade jobFacade = context.getBean(JobFacade.class);

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

        userFacade.openToWork(3L);
        userFacade.openToWork(1L);

        organizationFacade.register(new OrganizationRegistrationRequestDto("organizationName1"));
        organizationFacade.register(new OrganizationRegistrationRequestDto("organizationName2"));

        invitationFacade.sendInvitation(new InvitationRequestDto(3L, 1L));
        invitationFacade.sendInvitation(new InvitationRequestDto(1L, 2L));
        invitationFacade.acceptInvitation(new InvitationAcceptDto(3L, 1L));

        jobFacade.hire(new JobHireRequestDto(1L));
    }
}
