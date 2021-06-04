package com.davutbudak.hrms.business.abstracts;

import com.davutbudak.hrms.core.utilities.results.DataResult;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.entities.concretes.cv.Cv;
import com.davutbudak.hrms.entities.dtos.CvForAddDto;

import java.util.List;

public interface CvService {
    DataResult<List<Cv>> getByCandidate(int candidateId);
    DataResult<List<Cv>> getAllSortedByExperience();
    DataResult<List<Cv>> getAllSortedByGraduate();
    Result add(CvForAddDto cv);
}
