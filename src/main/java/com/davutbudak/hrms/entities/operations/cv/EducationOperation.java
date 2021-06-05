package com.davutbudak.hrms.entities.operations.cv;

import com.davutbudak.hrms.dataAccess.abstracts.cv.EducationDao;
import com.davutbudak.hrms.entities.concretes.University;
import com.davutbudak.hrms.entities.concretes.cv.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EducationOperation {
    private static EducationDao educationDao;

    @Autowired
    public EducationOperation(EducationDao educationDao) {
        EducationOperation.educationDao = educationDao;
    }

    public static University getUniversity(int educationId) {
        return educationDao.getUniversity(educationId);
    }

    public static void addUniversity(int educationId, int universityId) {
        Education education = educationDao.getById(educationId);
        education.setUniversityId(universityId);
        educationDao.save(education);
    }
}
