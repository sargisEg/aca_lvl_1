package com.aca.homework.week16.organization;

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

        OrganizationService organizationService = new OrganizationServiceImpl(organizationRepository);

        for (int i = 0; i < 10; i++) {
            organizationService.create(
                    new OrganizationCreateParams("name" + i, "fullAddress" + i));
        }

        organizationService.getById(10L);
    }
}
