package com.davutbudak.hrms.business.concretes;

import com.davutbudak.hrms.business.abstracts.JobPostingService;
import com.davutbudak.hrms.business.constants.Messages;
import com.davutbudak.hrms.core.utilities.results.*;
import com.davutbudak.hrms.dataAccess.abstracts.JobPostingDao;
import com.davutbudak.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {
    private JobPostingDao jobPostingDao;

    @Autowired
    public JobPostingManager(JobPostingDao jobPostingDao) {
        this.jobPostingDao = jobPostingDao;
    }

    @Override
    public DataResult<List<JobPosting>> findAllByActive() {
        return new SuccessDataResult<>(this.jobPostingDao.findAllByActive(true), Messages.JOB_POSTING_SUCCESS_ACTIVES_LISTED);
    }

    @Override
    public DataResult<List<JobPosting>> findAllByActiveOrderByReleaseDate() {
        return new SuccessDataResult<>(this.jobPostingDao.findAllByActiveOrderByReleaseDate(true),Messages.JOB_POSTING_SUCCESS_ACTIVES_SORTED_BY_RELEASE_DATE);
    }

    @Override
    public DataResult<List<JobPosting>> findByActiveAndEmployer(int employerId) {
        return new SuccessDataResult<>(this.jobPostingDao.findAllByActiveAndEmployer_Id(true,employerId),Messages.JOB_POSTING_SUCCESS_ACTIVES_LISTED_BY_EMPLOYER);
    }

    @Override
    public Result deActive(JobPosting jobPosting) {
        jobPosting.setActive(false);
        this.update(jobPosting);
        return new SuccessResult(Messages.JOB_POSTING_SUCCESS_DEACTIVATED);
    }

    @Override
    public Result add(JobPosting jobPosting) {

        this.jobPostingDao.save(jobPosting);
        return new SuccessResult(Messages.JOB_POSTING_SUCCESS_ADDED);
    }

    @Override
    public Result update(JobPosting jobPosting) {
        this.jobPostingDao.save(jobPosting);
        return new SuccessResult(Messages.JOB_POSTING_SUCCESS_UPDATED);
    }

}
