package com.davutbudak.hrms.business.concretes;

import com.davutbudak.hrms.business.abstracts.CandidateService;
import com.davutbudak.hrms.business.constants.Messages;
import com.davutbudak.hrms.core.utilities.results.*;
import com.davutbudak.hrms.core.utilities.verification.email.EmailVerification;
import com.davutbudak.hrms.core.utilities.verification.person.PersonVerification;
import com.davutbudak.hrms.dataAccess.abstracts.users.CandidateDao;
import com.davutbudak.hrms.entities.concretes.users.Candidate;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private final CandidateDao candidateDao;
    private final PersonVerification personVerification;
    private final EmailVerification emailVerification;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, PersonVerification personVerification, EmailVerification emailVerification) {
        this.candidateDao = candidateDao;
        this.personVerification = personVerification;
        this.emailVerification = emailVerification;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(candidateDao.findAll(), Messages.CANDIDATE_SUCCESS_DATA_LISTED);
    }

    @SneakyThrows
    @Override
    public Result add(Candidate candidate) {
        if (candidateDao.existsByEmail(candidate.getEmail()))
            return new ErrorResult(Messages.USER_ERROR_EMAIL_ALREADY_EXISTS);
        if (candidateDao.existsByIdentityNumber(candidate.getIdentityNumber()))
            return new ErrorResult(Messages.CANDIDATE_ERROR_IDENTITY_NUMBER_ALREADY_EXISTS);
        if (!personVerification.verify(Long.parseLong(candidate.getIdentityNumber()), candidate.getName(), candidate.getSurname(), candidate.getYearOfBirth()))
            return new ErrorResult(Messages.MERNIS_ERROR_VERIFICATION_FAILED);
        if (!emailVerification.verify(candidate.getEmail()))
            return new ErrorResult(Messages.EMAIL_VERIFICATION_ERROR_VERIFICATION_FAILED);

        candidateDao.save(candidate);
        return new SuccessResult(Messages.CANDIDATE_SUCCESS_ADDED);
    }
}
