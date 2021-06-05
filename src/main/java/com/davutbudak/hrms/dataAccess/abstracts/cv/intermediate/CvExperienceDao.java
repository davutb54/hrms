package com.davutbudak.hrms.dataAccess.abstracts.cv.intermediate;

import com.davutbudak.hrms.entities.concretes.cv.intermediate.CvExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvExperienceDao extends JpaRepository<CvExperience, Integer> {
}
