package com.davutbudak.hrms.dataAccess.abstracts.cv.intermediate;

import com.davutbudak.hrms.entities.concretes.cv.intermediate.CvEducation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvEducationDao extends JpaRepository<CvEducation, Integer> {
}
