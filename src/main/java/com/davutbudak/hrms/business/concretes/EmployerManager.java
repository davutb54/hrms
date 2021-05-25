package com.davutbudak.hrms.business.concretes;

import com.davutbudak.hrms.business.abstracts.EmployerService;
import com.davutbudak.hrms.business.constants.Messages;
import com.davutbudak.hrms.core.utilities.results.*;
import com.davutbudak.hrms.dataAccess.abstracts.EmployerDao;
import com.davutbudak.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerDao.findAll(), Messages.EMPLOYER_SUCCESS_DATA_LISTED);
    }

    @Override
    public Result add(Employer employer) {
        Pattern pattern= Pattern.compile("@" + employer.getWebsite());
        Matcher matcher = pattern.matcher(employer.getEmail());

        if (employer.getCompanyName().isEmpty())
            return new ErrorResult(Messages.EMPLOYER_ERROR_COMPANY_NAME_IS_BLANK);
        if (employer.getWebsite().isEmpty())
            return new ErrorResult(Messages.EMPLOYER_ERROR_WEBSITE_IS_BLANK);
        if (employer.getTelephone().isEmpty())
            return new ErrorResult(Messages.EMPLOYER_ERROR_TELEPHONE_IS_BLANK);
        if (employer.getEmail().isEmpty())
            return new ErrorResult(Messages.USER_ERROR_EMAIL_IS_BLANK);
        if (employer.getPassword().isEmpty())
            return new ErrorResult(Messages.USER_ERROR_PASSWORD_IS_BLANK);
        if (!matcher.matches())
            return new ErrorResult(Messages.USER_ERROR_EMAIL_IS_NOT_VALID);
        if (this.employerDao.existsByEmail(employer.getEmail()))
            return new ErrorResult(Messages.USER_ERROR_EMAIL_ALREADY_EXISTS);

        this.employerDao.save(employer);
        return new SuccessResult(Messages.EMPLOYER_SUCCESS_ADDED);
    }
}