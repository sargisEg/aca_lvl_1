package com.aca.homework.week16.organization.repository;

import com.aca.homework.week16.organization.OrganizationUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationUsersRepository extends JpaRepository<OrganizationUsers, Long> {
}
