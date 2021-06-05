package com.davutbudak.hrms.entities.operations;

import com.davutbudak.hrms.dataAccess.abstracts.LanguageDao;
import com.davutbudak.hrms.entities.concretes.cv.KnownLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LanguageOperation {
    private static LanguageDao languageDao;

    @Autowired
    public LanguageOperation(LanguageDao languageDao) {
        LanguageOperation.languageDao = languageDao;
    }

    private static List<KnownLanguage> getKnownLanguages(int languageId) {
        return languageDao.getKnownLanguages(languageId);
    }
}
