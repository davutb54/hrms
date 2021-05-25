package com.davutbudak.hrms.business.concretes;

import com.davutbudak.hrms.business.abstracts.CandidateService;
import com.davutbudak.hrms.business.constants.Messages;
import com.davutbudak.hrms.core.utilities.results.*;
import com.davutbudak.hrms.dataAccess.abstracts.CandidateDao;
import com.davutbudak.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;

    @Autowired
    public CandidateManager(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(this.candidateDao.findAll(), Messages.CANDIDATE_DATA_LISTED);
    }

    @Override
    public Result add(Candidate candidate) {
        if (candidate.getName().isEmpty())
            return new ErrorResult(Messages.CANDIDATE_ADD_ERROR);
        if (candidate.getSurname().isEmpty())
            return new ErrorResult(Messages.CANDIDATE_ADD_ERROR);
        if (candidate.getEmail().isEmpty())
            return new ErrorResult(Messages.CANDIDATE_ADD_ERROR);
        if (candidate.getPassword().isEmpty())
            return new ErrorResult(Messages.CANDIDATE_ADD_ERROR);
        if (candidate.getIdentityNumber().isEmpty())
            return new ErrorResult(Messages.CANDIDATE_ADD_ERROR);
        if (candidate.getYearOfBirth()==0)
            return new ErrorResult(Messages.CANDIDATE_ADD_ERROR);
        if (this.candidateDao.existsByEmail(candidate.getEmail()))
            return new ErrorResult(Messages.CANDIDATE_ADD_ERROR);
        if (this.candidateDao.existsByIdentityNumber(candidate.getIdentityNumber()))
            return new ErrorResult(Messages.CANDIDATE_ADD_ERROR);

        this.candidateDao.save(candidate);
        return new SuccessResult(Messages.CANDIDATE_ADDED);
    }
}
