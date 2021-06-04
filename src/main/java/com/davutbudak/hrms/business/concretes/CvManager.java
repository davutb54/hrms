package com.davutbudak.hrms.business.concretes;

import com.davutbudak.hrms.business.abstracts.CvService;
import com.davutbudak.hrms.core.utilities.results.DataResult;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.core.utilities.results.SuccessDataResult;
import com.davutbudak.hrms.core.utilities.results.SuccessResult;
import com.davutbudak.hrms.dataAccess.abstracts.cv.*;
import com.davutbudak.hrms.entities.concretes.cv.Cv;
import com.davutbudak.hrms.entities.dtos.CvForAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvManager implements CvService {
    private final CvDao cvDao;

    @Autowired
    public CvManager(CvDao cvDao) {
        this.cvDao = cvDao;
    }

    @Override
    public DataResult<List<Cv>> getByCandidate(int candidateId) {
        return new SuccessDataResult<>(cvDao.findAll());
    }

    @Override
    public DataResult<List<Cv>> getAllSortedByExperience() {
        return new SuccessDataResult<>(cvDao.getAllSortedByExperience());
    }


    @Override
    public DataResult<List<Cv>> getAllSortedByGraduate() {
        return new SuccessDataResult<>(cvDao.getAllSortedByGraduate());
    }

    @Override
    public Result add(CvForAddDto cv) {
        Cv entity = new Cv(cv.getId(), cv.getCoverLetter(), cv.getGithub(), cv.getLinkedin());
        cvDao.save(entity);
        return new SuccessResult();
    }
}
