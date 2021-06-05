package com.davutbudak.hrms.dataAccess.abstracts;

import com.davutbudak.hrms.entities.concretes.Language;
import com.davutbudak.hrms.entities.concretes.cv.KnownLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LanguageDao extends JpaRepository<Language, Integer> {
    @Query("select kl from KnownLanguage as kl join Language as l on kl.languageId = l.id where l.id = :languageId")
    List<KnownLanguage> getKnownLanguages(@Param("languageId") int languageId);
}
