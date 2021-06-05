package com.davutbudak.hrms.dataAccess.abstracts.cv.intermediate;

import com.davutbudak.hrms.entities.concretes.cv.intermediate.CvKnownLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvKnownLanguageDao extends JpaRepository<CvKnownLanguage, Integer> {
}
