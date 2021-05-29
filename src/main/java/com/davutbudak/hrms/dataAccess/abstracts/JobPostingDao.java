package com.davutbudak.hrms.dataAccess.abstracts;

import com.davutbudak.hrms.entities.concretes.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting,Integer> {
    List<JobPosting> findAllByActive(boolean isActive);
    List<JobPosting> findAllByActiveOrderByReleaseDate(boolean isActive);
    List<JobPosting> findAllByActiveAndEmployer_Id(boolean isActive, int employerId);

}
