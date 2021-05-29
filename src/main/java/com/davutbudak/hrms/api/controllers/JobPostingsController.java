package com.davutbudak.hrms.api.controllers;

import com.davutbudak.hrms.business.abstracts.JobPostingService;
import com.davutbudak.hrms.core.utilities.results.DataResult;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPostings")
public class JobPostingsController {
    private JobPostingService jobPostingService;

    @Autowired
    public JobPostingsController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @GetMapping("/getActives")
    public DataResult<List<JobPosting>> getActiveJobPostings(){
        return this.jobPostingService.findAllByActive();
    }

    @GetMapping("/getActivesSortedByReleaseDate")
    public DataResult<List<JobPosting>> getActivesSortedByReleaseDate(){
        return this.jobPostingService.findAllByActiveOrderByReleaseDate();
    }

    @GetMapping("/getActivesByEmployer")
    public DataResult<List<JobPosting>> getActivesByEmployer(@RequestParam int employerId){
        return this.jobPostingService.findByActiveAndEmployer(employerId);
    }

    @PostMapping("/deActive")
    public Result deActive(@RequestBody JobPosting jobPosting){
        return this.jobPostingService.deActive(jobPosting);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosting jobPosting){
        return this.jobPostingService.add(jobPosting);
    }
}
