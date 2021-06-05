package com.davutbudak.hrms.dataAccess.abstracts.users;

import com.davutbudak.hrms.entities.concretes.cv.Cv;
import com.davutbudak.hrms.entities.concretes.users.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
    boolean existsByEmail(String email);

    boolean existsByIdentityNumber(String identityNumber);

    @Query("select cv from Cv as cv join Candidate as c on c.id = cv.candidateId where c.id = :candidateId")
    List<Cv> getCvs(@Param("candidateId") int candidateId);
}
