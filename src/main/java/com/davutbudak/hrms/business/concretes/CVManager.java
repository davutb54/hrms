package com.davutbudak.hrms.business.concretes;

import com.davutbudak.hrms.business.abstracts.CVService;
import com.davutbudak.hrms.core.utilities.results.DataResult;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.core.utilities.results.SuccessDataResult;
import com.davutbudak.hrms.dataAccess.abstracts.CVDao;
import com.davutbudak.hrms.entities.concretes.cv.CV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CVManager implements CVService {
    private CVDao cvDao;

    @Autowired
    public CVManager(CVDao cvDao) {
        this.cvDao = cvDao;
    }

    @Override
    public DataResult<List<CV>> getByCandidate(int candidateId) {
        return new SuccessDataResult<>(this.cvDao.findAll());
    }

    @Override
    public DataResult<List<CV>> getAllSortedByExperience() {
        return null;
    }

    @Override
    public DataResult<List<CV>> getAllSortedByGraduate() {
        return null;
    }

    @Override
    public Result add(CV cv) {
        return null;
    }
}
