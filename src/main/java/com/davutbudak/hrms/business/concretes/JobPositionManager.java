package com.davutbudak.hrms.business.concretes;

import com.davutbudak.hrms.business.abstracts.JobPositionService;
import com.davutbudak.hrms.business.constants.Messages;
import com.davutbudak.hrms.core.utilities.results.*;
import com.davutbudak.hrms.dataAccess.abstracts.JobPositionDao;
import com.davutbudak.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    private final JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(jobPositionDao.findAll(), Messages.JOB_POSITION_SUCCESS_DATA_LISTED);
    }

    @Override
    public Result add(JobPosition jobPosition) {
        if (jobPositionDao.existsByName(jobPosition.getName()))
            return new ErrorResult(Messages.JOB_POSITION_ERROR_ALREADY_EXISTS);

        jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.JOB_POSITION_SUCCESS_ADDED);
    }

}