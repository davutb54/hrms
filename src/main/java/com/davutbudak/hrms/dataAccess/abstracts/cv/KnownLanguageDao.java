package com.davutbudak.hrms.dataAccess.abstracts.cv;

import com.davutbudak.hrms.entities.concretes.Language;
import com.davutbudak.hrms.entities.concretes.cv.KnownLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KnownLanguageDao extends JpaRepository<KnownLanguage, Integer> {
    @Query("select l from Language as l join KnownLanguage as kl on l.id = kl.languageId where kl.id = :knownLanguageId")
    Language getLanguage(@Param("knownLanguageId") int knownLanguageId);
}
