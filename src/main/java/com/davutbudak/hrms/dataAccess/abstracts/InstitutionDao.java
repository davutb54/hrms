package com.davutbudak.hrms.dataAccess.abstracts;

import com.davutbudak.hrms.entities.concretes.Institution;
import com.davutbudak.hrms.entities.concretes.cv.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstitutionDao extends JpaRepository<Institution, Integer> {
    @Query("select e from Experience as e join Institution as i on e.institutionId = i.id where i.id = :institutionId")
    List<Experience> getExperiences(@Param("institutionId") int institutionId);
}
