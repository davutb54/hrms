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
        if (jobPosting.getEmployer()==null)
            return new ErrorResult(Messages.JOB_POSTING_ERROR_EMPLOYER_IS_BLANK);
        if (jobPosting.getJobPosition()==null)
            return new ErrorResult(Messages.JOB_POSTING_ERROR_JOB_POSITION_IS_BLANK);
        if (jobPosting.getCity()==null)
            return new ErrorResult(Messages.JOB_POSTING_ERROR_CITY_IS_BLANK);
        if (jobPosting.getJobDescription().isEmpty())
            return new ErrorResult(Messages.JOB_POSTING_ERROR_JOB_DESCRIPTION_IS_BLANK);
        if (jobPosting.getNumberOfOpenPositions()<=0)
            return new ErrorResult(Messages.JOB_POSTING_ERROR_NUMBER_OF_OPEN_POSITIONS_IS_BLANK);
        if (jobPosting.getReleaseDate()==null)
            return new ErrorResult(Messages.JOB_POSTING_ERROR_RELEASE_DATE_IS_BLANK);
        if (jobPosting.getDeadline()==null)
            return new ErrorResult(Messages.JOB_POSTING_ERROR_DEADLINE_IS_BLANK);
        if (!jobPosting.isActive() && jobPosting.isActive())
            return new ErrorResult(Messages.JOB_POSTING_ERROR_ACTIVE_IS_BLANK);

        this.jobPostingDao.save(jobPosting);
        return new SuccessResult(Messages.JOB_POSTING_SUCCESS_ADDED);
    }

    @Override
    public Result update(JobPosting jobPosting) {
        this.jobPostingDao.save(jobPosting);
        return new SuccessResult(Messages.JOB_POSTING_SUCCESS_UPDATED);
    }

}
