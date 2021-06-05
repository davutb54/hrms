package com.davutbudak.hrms.dataAccess.abstracts;

import com.davutbudak.hrms.entities.concretes.Technology;
import com.davutbudak.hrms.entities.concretes.cv.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UniversityDao extends JpaRepository<Technology, Integer> {
    @Query("select e from Education as e join University as u on e.universityId = u.id where u.id = :universityId")
    List<Education> getEducations(@Param("universityId") int universityId);
}
