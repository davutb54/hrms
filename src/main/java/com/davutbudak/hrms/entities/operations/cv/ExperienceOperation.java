package com.davutbudak.hrms.entities.operations.cv;

import com.davutbudak.hrms.dataAccess.abstracts.cv.ExperienceDao;
import com.davutbudak.hrms.entities.concretes.Institution;
import com.davutbudak.hrms.entities.concretes.JobPosition;
import com.davutbudak.hrms.entities.concretes.cv.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExperienceOperation {
    private static ExperienceDao experienceDao;

    @Autowired
    public ExperienceOperation(ExperienceDao experienceDao) {
        ExperienceOperation.experienceDao = experienceDao;
    }

    public static JobPosition getJobPosition(int experienceId) {
        return experienceDao.getJobPosition(experienceId);
    }

    public static Institution getInstitution(int experienceId) {
        return experienceDao.getInstitution(experienceId);
    }

    public static void addJobPosition(int experienceId, int jobPositionId) {
        Experience experience = experienceDao.getById(experienceId);
        experience.setJobPositionId(jobPositionId);
        experienceDao.save(experience);
    }

    public static void addInstitution(int experienceId, int institutionId) {
        Experience experience = experienceDao.getById(experienceId);
        experience.setInstitutionId(institutionId);
        experienceDao.save(experience);
    }
}
