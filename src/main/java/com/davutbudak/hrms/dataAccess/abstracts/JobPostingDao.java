package com.davutbudak.hrms.dataAccess.abstracts;

import com.davutbudak.hrms.entities.concretes.JobPosting;
import com.davutbudak.hrms.entities.dtos.JobPostingForListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting,Integer> {
    @Query(value = "select new com.davutbudak.hrms.entities.dtos.JobPostingForListDto(j.id,j.employer.companyName,j.jobPosition.name,j.numberOfOpenPositions,j.releaseDate,j.deadline) from JobPosting as j where j.active=:isActive")
    List<JobPostingForListDto> getByActive(@Param("isActive") boolean isActive);
    @Query("select new com.davutbudak.hrms.entities.dtos.JobPostingForListDto(j.id,j.employer.companyName,j.jobPosition.name,j.numberOfOpenPositions,j.releaseDate,j.deadline) from JobPosting as j where j.active=:isActive")
    List<JobPostingForListDto> getByActiveSortedByReleaseDate(@Param("isActive") boolean isActive);
    @Query("select new com.davutbudak.hrms.entities.dtos.JobPostingForListDto(j.id,j.employer.companyName,j.jobPosition.name,j.numberOfOpenPositions,j.releaseDate,j.deadline) from JobPosting as j where j.active=:isActive and j.employer.id=:employerId")
    List<JobPostingForListDto> getByActiveAndEmployer(@Param("isActive") boolean isActive,@Param("employerId") int employerId);
}
