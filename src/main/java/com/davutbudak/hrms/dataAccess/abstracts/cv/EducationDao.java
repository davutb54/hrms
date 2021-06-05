package com.davutbudak.hrms.dataAccess.abstracts.cv;

import com.davutbudak.hrms.entities.concretes.University;
import com.davutbudak.hrms.entities.concretes.cv.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EducationDao extends JpaRepository<Education, Integer> {
    @Query("select u from University as u join Education as e on u.id = e.universityId where e.id = :educationId")
    University getUniversity(@Param("educationId") int educationId);
}
