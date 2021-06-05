package com.davutbudak.hrms.entities.operations;

import com.davutbudak.hrms.dataAccess.abstracts.UniversityDao;
import com.davutbudak.hrms.entities.concretes.cv.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniversityOperation {
    private static UniversityDao universityDao;

    @Autowired
    public UniversityOperation(UniversityDao universityDao) {
        UniversityOperation.universityDao = universityDao;
    }

    public static List<Education> getEducations(int universityId) {
        return universityDao.getEducations(universityId);
    }
}
