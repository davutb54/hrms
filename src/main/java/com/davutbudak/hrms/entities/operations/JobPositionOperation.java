package com.davutbudak.hrms.entities.operations;

import com.davutbudak.hrms.dataAccess.abstracts.JobPositionDao;
import com.davutbudak.hrms.entities.concretes.JobPosting;
import com.davutbudak.hrms.entities.concretes.cv.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobPositionOperation {
    private static JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionOperation(JobPositionDao jobPositionDao) {
        JobPositionOperation.jobPositionDao = jobPositionDao;
    }

    private static List<JobPosting> getJobPostings(int jobPositionId) {
        return jobPositionDao.getJobPostings(jobPositionId);
    }

    private static List<Experience> getExperiences(int jobPositionId) {
        return jobPositionDao.getExperiences(jobPositionId);
    }
}
