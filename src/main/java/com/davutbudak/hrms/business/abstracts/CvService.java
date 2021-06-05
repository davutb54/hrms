package com.davutbudak.hrms.business.abstracts;

import com.davutbudak.hrms.core.utilities.results.DataResult;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.entities.dtos.cv.CvForAddDto;
import com.davutbudak.hrms.entities.dtos.cv.CvForListDto;

import java.util.List;

public interface CvService {
    DataResult<CvForListDto> getByCandidate(int candidateId);

    DataResult<List<CvForListDto>> getAllSortedByExperience();

    DataResult<List<CvForListDto>> getAllSortedByGraduate();

    Result add(CvForAddDto cv);
}
