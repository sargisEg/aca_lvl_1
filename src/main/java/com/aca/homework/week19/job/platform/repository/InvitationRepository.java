package com.aca.homework.week19.job.platform.repository;

import com.aca.homework.week19.job.platform.entity.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Long> {

}
