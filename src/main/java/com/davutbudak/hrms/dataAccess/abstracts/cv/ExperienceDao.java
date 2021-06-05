package com.davutbudak.hrms.dataAccess.abstracts.cv;

import com.davutbudak.hrms.entities.concretes.Institution;
import com.davutbudak.hrms.entities.concretes.JobPosition;
import com.davutbudak.hrms.entities.concretes.cv.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExperienceDao extends JpaRepository<Experience, Integer> {
    @Query("select jb from JobPosition as jb join Experience as e on jb.id = e.jobPositionId where e.id = :experienceId")
    JobPosition getJobPosition(@Param("experienceId") int experienceId);

    @Query("select i from Institution as i join Experience as e on i.id = e.institutionId where e.id = :experienceId")
    Institution getInstitution(@Param("experienceId") int experienceId);
}
