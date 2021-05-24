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
    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(this.jobPositionDao.findAll(), Messages.JOB_POSITION_DATA_LISTED);
    }

    @Override
    public Result add(JobPosition jobPosition) {
        if (this.jobPositionDao.existsById(jobPosition.getId()))
            return new ErrorResult(Messages.JOB_POSITION_ADD_ERROR);

        this.jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.JOB_POSITION_ADDED);
    }

    @Override
    public Result update(JobPosition jobPosition) {
        JobPosition jobPositionInDB = this.jobPositionDao.getById(jobPosition.getId());
        jobPositionInDB.setName(jobPosition.getName());
        this.jobPositionDao.save(jobPositionInDB);

        return new SuccessResult(Messages.JOB_POSITION_UPDATED);
    }

    @Override
    public Result delete(JobPosition jobPosition) {
        this.jobPositionDao.delete(jobPosition);
        return new SuccessResult(Messages.JOB_POSITION_DELETED);
    }

}