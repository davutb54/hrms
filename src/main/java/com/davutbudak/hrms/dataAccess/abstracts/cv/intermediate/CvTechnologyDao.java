package com.davutbudak.hrms.dataAccess.abstracts.cv.intermediate;

import com.davutbudak.hrms.entities.concretes.cv.intermediate.CvTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvTechnologyDao extends JpaRepository<CvTechnology, Integer> {
}
