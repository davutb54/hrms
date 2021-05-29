package com.davutbudak.hrms.business.abstracts;

import com.davutbudak.hrms.core.utilities.results.DataResult;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.entities.concretes.JobPosting;

import java.util.List;

public interface JobPostingService {
    DataResult<List<JobPosting>> findAllByActive();
    DataResult<List<JobPosting>> findAllByActiveOrderByReleaseDate();
    DataResult<List<JobPosting>> findByActiveAndEmployer(int employerId);
    Result deActive(JobPosting jobPosting);
    Result add(JobPosting jobPosting);
    Result update(JobPosting jobPosting);
}
