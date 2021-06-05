package com.davutbudak.hrms.dataAccess.abstracts.users;

import com.davutbudak.hrms.entities.concretes.JobPosting;
import com.davutbudak.hrms.entities.concretes.users.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    boolean existsByEmail(String email);

    @Query("select jp from JobPosting as jp join Employer as e on e.id = jp.employerId where e.id = :employerId")
    List<JobPosting> getJobPostings(@Param("employerId") int employerId);
}
