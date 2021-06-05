package com.davutbudak.hrms.dataAccess.abstracts;

import com.davutbudak.hrms.entities.concretes.JobPosition;
import com.davutbudak.hrms.entities.concretes.JobPosting;
import com.davutbudak.hrms.entities.concretes.cv.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
    boolean existsByName(String name);

    @Query("select jp from JobPosting as jp join JobPosition as j on jp.jobPositionId = j.id where j.id = :jobPositionId")
    List<JobPosting> getJobPostings(@Param("jobPositionId") int jobPositionId);

    @Query("select e from Experience  as e join JobPosition as j on e.jobPositionId = j.id where j.id = :jobPositionId")
    List<Experience> getExperiences(@Param("jobPositionId") int jobPositionId);
}