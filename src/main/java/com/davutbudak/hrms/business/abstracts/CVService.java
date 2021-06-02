package com.davutbudak.hrms.business.abstracts;

import com.davutbudak.hrms.core.utilities.results.DataResult;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.entities.concretes.cv.CV;

import java.util.List;

public interface CVService {
    DataResult<List<CV>> getByCandidate(int candidateId);
    DataResult<List<CV>> getAllSortedByExperience();
    DataResult<List<CV>> getAllSortedByGraduate();
    Result add(CV cv);
}
