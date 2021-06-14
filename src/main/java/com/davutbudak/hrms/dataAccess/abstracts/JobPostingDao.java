package com.davutbudak.hrms.dataAccess.abstracts;

import com.davutbudak.hrms.entities.concretes.City;
import com.davutbudak.hrms.entities.concretes.JobPosition;
import com.davutbudak.hrms.entities.concretes.JobPosting;
import com.davutbudak.hrms.entities.concretes.users.Employer;
import com.davutbudak.hrms.entities.dtos.JobPostingForListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
    @Query("select new com.davutbudak.hrms.entities.dtos.JobPostingForListDto(jp.id,e.companyName,j.name,jp.numberOfOpenPositions,jp.releaseDate,jp.deadline,jp.workTime,jp.workPlace) from JobPosting as jp join Employer as e on e.id = jp.employerId join JobPosition as j on jp.jobPositionId = j.id where jp.active = :isActive")
    List<JobPostingForListDto> getByActive(@Param("isActive") boolean isActive);

    @Query("select new com.davutbudak.hrms.entities.dtos.JobPostingForListDto(jp.id,e.companyName,j.name,jp.numberOfOpenPositions,jp.releaseDate,jp.deadline,jp.workTime,jp.workPlace) from JobPosting as jp join Employer as e on e.id = jp.employerId join JobPosition as j on jp.jobPositionId = j.id where jp.active = :isActive order by jp.releaseDate")
    List<JobPostingForListDto> getByActiveSortedByReleaseDate(@Param("isActive") boolean isActive);

    @Query("select new com.davutbudak.hrms.entities.dtos.JobPostingForListDto(jp.id,e.companyName,j.name,jp.numberOfOpenPositions,jp.releaseDate,jp.deadline,jp.workTime,jp.workPlace) from JobPosting as jp join Employer as e on e.id = jp.employerId join JobPosition as j on jp.jobPositionId = j.id where jp.active = :isActive and e.id = :employerId")
    List<JobPostingForListDto> getByActiveAndEmployer(@Param("isActive") boolean isActive, @Param("employerId") int employerId);

    @Query("select e from Employer as e join JobPosting as jp on e.id = jp.employerId where jp.id = :jobPostingId")
    Employer getEmployer(@Param("jobPostingId") int jobPostingId);

    @Query("select j from JobPosition as j join JobPosting as jp on j.id = jp.jobPositionId where jp.id = :jobPostingId")
    JobPosition getJobPosition(@Param("jobPostingId") int jobPostingId);

    @Query("select c from City as c join JobPosting as jp on c.id = jp.cityId where jp.id = :jobPostingId")
    City getCity(@Param("jobPostingId") int jobPostingId);
}
