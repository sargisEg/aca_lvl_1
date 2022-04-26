package com.aca.homework.week16.organization;

import com.aca.homework.week16.organization.create.params.OrganizationCreateParams;
import com.aca.homework.week16.organization.create.params.OrganizationUsersCreateParams;
import com.aca.homework.week16.organization.create.params.UserCreateParams;
import com.aca.homework.week16.organization.repository.OrganizationRepository;
import com.aca.homework.week16.organization.repository.OrganizationUsersRepository;
import com.aca.homework.week16.organization.repository.UserRepository;
import com.aca.homework.week16.organization.service.OrganizationService;
import com.aca.homework.week16.organization.service.OrganizationUsersAddingService;
import com.aca.homework.week16.organization.service.UserService;
import com.aca.homework.week16.organization.service.impl.OrganizationServiceImpl;
import com.aca.homework.week16.organization.service.impl.OrganizationUsersAddingServiceImpl;
import com.aca.homework.week16.organization.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Main {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        OrganizationRepository organizationRepository = context.getBean(OrganizationRepository.class);
        UserRepository userRepository = context.getBean(UserRepository.class);
        OrganizationUsersRepository organizationUsersRepository = context.getBean(OrganizationUsersRepository.class);

        OrganizationService organizationService = new OrganizationServiceImpl(organizationRepository);
        UserService userService = new UserServiceImpl(userRepository);
        OrganizationUsersAddingService organizationUsersAddingService = new OrganizationUsersAddingServiceImpl(organizationUsersRepository);

        for (int i = 0; i < 10; i++) {
            organizationService.create(
                    new OrganizationCreateParams("name" + i, "fullAddress" + i));
        }

        for (int i = 0; i < 10; i++) {
            userService.create(
                    new UserCreateParams("First" + i, "Second" + i));
        }

        final Organization organization = organizationService.getById(10L);
        final Organization organization1 = organizationService.getById(5L);
        final User user1 = userService.getById(15L);
        final User user2 = userService.getById(17L);

        organizationUsersAddingService.addUserToOrganization(
                new OrganizationUsersCreateParams(organization, user1));

        organizationUsersAddingService.addUserToOrganization(
                new OrganizationUsersCreateParams(organization, user2));

        organizationUsersAddingService.addUserToOrganization(
                new OrganizationUsersCreateParams(organization1, user1));
    }
}
