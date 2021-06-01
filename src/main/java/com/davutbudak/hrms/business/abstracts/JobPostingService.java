package com.davutbudak.hrms.business.abstracts;

import com.davutbudak.hrms.core.utilities.results.DataResult;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.entities.concretes.JobPosting;
import com.davutbudak.hrms.entities.dtos.JobPostingForListDto;

import java.util.List;

public interface JobPostingService {
    DataResult<List<JobPostingForListDto>> getByActive();
    DataResult<List<JobPostingForListDto>> getByActiveSortedByReleaseDate();
    DataResult<List<JobPostingForListDto>> getByActiveAndEmployer(int employerId);
    Result deActive(JobPosting jobPosting);
    Result add(JobPosting jobPosting);
    Result update(JobPosting jobPosting);
}
