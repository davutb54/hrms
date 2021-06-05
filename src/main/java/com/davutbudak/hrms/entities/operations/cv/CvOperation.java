package com.davutbudak.hrms.entities.operations.cv;

import com.davutbudak.hrms.dataAccess.abstracts.cv.CvDao;
import com.davutbudak.hrms.dataAccess.abstracts.cv.intermediate.*;
import com.davutbudak.hrms.entities.concretes.Image;
import com.davutbudak.hrms.entities.concretes.Technology;
import com.davutbudak.hrms.entities.concretes.cv.Cv;
import com.davutbudak.hrms.entities.concretes.cv.Education;
import com.davutbudak.hrms.entities.concretes.cv.Experience;
import com.davutbudak.hrms.entities.concretes.cv.KnownLanguage;
import com.davutbudak.hrms.entities.concretes.cv.intermediate.*;
import com.davutbudak.hrms.entities.concretes.users.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CvOperation {
    private static CvDao cvDao;
    private static CvEducationDao cvEducationDao;
    private static CvKnownLanguageDao cvKnownLanguageDao;
    private static CvExperienceDao cvExperienceDao;
    private static CvTechnologyDao cvTechnologyDao;

    @Autowired
    public CvOperation(CvDao cvDao, CvEducationDao cvEducationDao, CvKnownLanguageDao cvKnownLanguageDao, CvExperienceDao cvExperienceDao, CvTechnologyDao cvTechnologyDao) {
        CvOperation.cvDao = cvDao;
        CvOperation.cvEducationDao = cvEducationDao;
        CvOperation.cvKnownLanguageDao = cvKnownLanguageDao;
        CvOperation.cvExperienceDao = cvExperienceDao;
        CvOperation.cvTechnologyDao = cvTechnologyDao;
    }

    public static Candidate getCandidate(int cvId) {
        return cvDao.getCandidate(cvId);
    }

    public static Image getImage(int cvId) {
        return cvDao.getImage(cvId);
    }

    public static List<Education> getEducations(int cvId) {
        return cvDao.getEducations(cvId);
    }

    public static List<KnownLanguage> getKnownLanguages(int cvId) {
        return cvDao.getKnownLanguages(cvId);
    }

    public static List<Experience> getExperiences(int cvId) {
        return cvDao.getExperiences(cvId);
    }

    public static List<Technology> getTechnologies(int cvId) {
        return cvDao.getTechnologies(cvId);
    }

    public static void addCandidate(int cvId, int candidateId) {
        Cv cv = cvDao.getById(cvId);
        cv.setCandidateId(candidateId);
        cvDao.save(cv);
    }

    public static void addImage(int cvId, int imageId) {
        Cv cv = cvDao.getById(cvId);
        cv.setImageId(imageId);
        cvDao.save(cv);
    }

    public static void addEducation(int cvId, int educationId) {
        CvEducation cvEducation = CvEducation.builder().cvId(cvId).educationId(educationId).build();
        cvEducationDao.save(cvEducation);
    }

    public static void addKnownLanguage(int cvId, int knownLanguageId) {
        CvKnownLanguage cvKnownLanguage = CvKnownLanguage.builder().cvId(cvId).knownLanguageId(knownLanguageId).build();
        cvKnownLanguageDao.save(cvKnownLanguage);
    }

    public static void addExperience(int cvId, int experienceId) {
        CvExperience cvExperience = CvExperience.builder().cvId(cvId).experienceId(experienceId).build();
        cvExperienceDao.save(cvExperience);
    }

    public static void addTechnology(int cvId, int technologyId) {
        CvTechnology cvTechnology = CvTechnology.builder().cvId(cvId).technologyId(technologyId).build();
        cvTechnologyDao.save(cvTechnology);
    }
}
