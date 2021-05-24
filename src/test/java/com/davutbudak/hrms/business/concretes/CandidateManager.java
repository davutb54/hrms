package com.davutbudak.hrms.business.concretes;

import com.davutbudak.hrms.business.abstracts.CandidateService;
import com.davutbudak.hrms.business.constants.Messages;
import com.davutbudak.hrms.core.utilities.results.DataResult;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.core.utilities.results.SuccessDataResult;
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
        return null;
    }

    @Override
    public Result update(Candidate candidate) {
        return null;
    }

    @Override
    public Result delete(Candidate candidate) {
        return null;
    }
}
