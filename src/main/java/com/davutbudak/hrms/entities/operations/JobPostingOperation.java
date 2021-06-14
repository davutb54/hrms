package com.davutbudak.hrms.entities.operations;

import com.davutbudak.hrms.dataAccess.abstracts.JobPostingDao;
import com.davutbudak.hrms.entities.concretes.City;
import com.davutbudak.hrms.entities.concretes.JobPosition;
import com.davutbudak.hrms.entities.concretes.JobPosting;
import com.davutbudak.hrms.entities.concretes.users.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobPostingOperation {
    private static JobPostingDao jobPostingDao;

    @Autowired
    public JobPostingOperation(JobPostingDao jobPostingDao) {
        JobPostingOperation.jobPostingDao = jobPostingDao;
    }

    public static Employer getEmployer(int jobPostingId) {
        return jobPostingDao.getEmployer(jobPostingId);
    }

    public static JobPosition getJobPosition(int jobPostingId) {
        return jobPostingDao.getJobPosition(jobPostingId);
    }

    public static City getCity(int jobPostingId) {
        return jobPostingDao.getCity(jobPostingId);
    }

    public static void addEmployer(int jobPostingId, int employerId) {
        JobPosting jobPosting = jobPostingDao.getById(jobPostingId);
        jobPosting.setEmployerId(employerId);
        jobPostingDao.save(jobPosting);
    }

    public static void addJobPosition(int jobPostingId, int jobPositionId) {
        JobPosting jobPosting = jobPostingDao.getById(jobPostingId);
        jobPosting.setJobPositionId(jobPositionId);
        jobPostingDao.save(jobPosting);
    }

    public static void addCity(int jobPostingId, int cityId) {
        JobPosting jobPosting = jobPostingDao.getById(jobPostingId);
        jobPosting.setCityId(cityId);
        jobPostingDao.save(jobPosting);
    }
}
