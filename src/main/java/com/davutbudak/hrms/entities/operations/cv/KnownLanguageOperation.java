package com.davutbudak.hrms.entities.operations.cv;

import com.davutbudak.hrms.dataAccess.abstracts.cv.KnownLanguageDao;
import com.davutbudak.hrms.entities.concretes.Language;
import com.davutbudak.hrms.entities.concretes.cv.KnownLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KnownLanguageOperation {
    private static KnownLanguageDao knownLanguageDao;

    @Autowired
    public KnownLanguageOperation(KnownLanguageDao knownLanguageDao) {
        KnownLanguageOperation.knownLanguageDao = knownLanguageDao;
    }

    public static Language getLanguage(int knownLanguageId) {
        return knownLanguageDao.getLanguage(knownLanguageId);
    }

    public static void addLanguage(int knownLanguageId, int languageId) {
        KnownLanguage knownLanguage = knownLanguageDao.getById(knownLanguageId);
        knownLanguage.setLanguageId(languageId);
        knownLanguageDao.save(knownLanguage);
    }
}
