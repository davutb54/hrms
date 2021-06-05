package com.davutbudak.hrms.entities.operations;

import com.davutbudak.hrms.dataAccess.abstracts.InstitutionDao;
import com.davutbudak.hrms.entities.concretes.cv.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InstitutionOperation {
    private static InstitutionDao institutionDao;

    @Autowired
    public InstitutionOperation(InstitutionDao institutionDao) {
        InstitutionOperation.institutionDao = institutionDao;
    }

    private static List<Experience> getExperiences(int institutionId) {
        return institutionDao.getExperiences(institutionId);
    }
}
