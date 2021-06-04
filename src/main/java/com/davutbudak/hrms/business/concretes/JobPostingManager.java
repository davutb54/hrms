package com.davutbudak.hrms.business.concretes;

import com.davutbudak.hrms.business.abstracts.JobPostingService;
import com.davutbudak.hrms.business.constants.Messages;
import com.davutbudak.hrms.core.utilities.results.*;
import com.davutbudak.hrms.dataAccess.abstracts.JobPostingDao;
import com.davutbudak.hrms.entities.concretes.JobPosting;
import com.davutbudak.hrms.entities.dtos.JobPostingForListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {
    private final JobPostingDao jobPostingDao;

    @Autowired
    public JobPostingManager(JobPostingDao jobPostingDao) {
        this.jobPostingDao = jobPostingDao;
    }

    @Override
    public DataResult<List<JobPostingForListDto>> getByActive() {
        return new SuccessDataResult<>(jobPostingDao.getByActive(true), Messages.JOB_POSTING_SUCCESS_ACTIVES_LISTED);
    }

    @Override
    public DataResult<List<JobPostingForListDto>> getByActiveSortedByReleaseDate() {
        return new SuccessDataResult<>(jobPostingDao.getByActiveSortedByReleaseDate(true),Messages.JOB_POSTING_SUCCESS_ACTIVES_SORTED_BY_RELEASE_DATE);
    }

    @Override
    public DataResult<List<JobPostingForListDto>> getByActiveAndEmployer(int employerId) {
        return new SuccessDataResult<>(jobPostingDao.getByActiveAndEmployer(true,employerId),Messages.JOB_POSTING_SUCCESS_ACTIVES_LISTED_BY_EMPLOYER);
    }

    @Override
    public Result deActive(JobPosting jobPosting) {
        jobPosting.setActive(false);
        jobPostingDao.save(jobPosting);
        return new SuccessResult(Messages.JOB_POSTING_SUCCESS_DEACTIVATED);
    }

    @Override
    public Result add(JobPosting jobPosting) {

        jobPostingDao.save(jobPosting);
        return new SuccessResult(Messages.JOB_POSTING_SUCCESS_ADDED);
    }
}
