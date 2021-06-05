package com.davutbudak.hrms.entities.operations.users;

import com.davutbudak.hrms.dataAccess.abstracts.users.EmployerDao;
import com.davutbudak.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployerOperation {
    private static EmployerDao employerDao;

    @Autowired
    public EmployerOperation(EmployerDao employerDao) {
        EmployerOperation.employerDao = employerDao;
    }

    private static List<JobPosting> getJobPostings(int employerId) {
        return employerDao.getJobPostings(employerId);
    }
}
