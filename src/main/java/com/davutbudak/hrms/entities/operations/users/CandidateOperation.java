package com.davutbudak.hrms.entities.operations.users;

import com.davutbudak.hrms.dataAccess.abstracts.users.CandidateDao;
import com.davutbudak.hrms.entities.concretes.cv.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CandidateOperation {
    private static CandidateDao candidateDao;

    @Autowired
    public CandidateOperation(CandidateDao candidateDao) {
        CandidateOperation.candidateDao = candidateDao;
    }

    public static List<Cv> getCvs(int candidateId) {
        return candidateDao.getCvs(candidateId);
    }
}
