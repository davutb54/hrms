package com.davutbudak.hrms.api.controllers;

import com.davutbudak.hrms.business.abstracts.JobPostingService;
import com.davutbudak.hrms.core.utilities.results.DataResult;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.entities.concretes.JobPosting;
import com.davutbudak.hrms.entities.dtos.JobPostingForListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPostings")
@CrossOrigin
public class JobPostingsController {
    private final JobPostingService jobPostingService;

    @Autowired
    public JobPostingsController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @GetMapping("/getActives")
    public ResponseEntity<DataResult<List<JobPostingForListDto>>> getActiveJobPostings() {
        return ResponseEntity.ok(jobPostingService.getByActive());
    }

    @GetMapping("/getActivesSortedByReleaseDate")
    public ResponseEntity<DataResult<List<JobPostingForListDto>>> getActivesSortedByReleaseDate() {
        return ResponseEntity.ok(jobPostingService.getByActiveSortedByReleaseDate());
    }

    @GetMapping("/getActivesByEmployer")
    public ResponseEntity<DataResult<List<JobPostingForListDto>>> getActivesByEmployer(@RequestParam int employerId) {
        return ResponseEntity.ok(jobPostingService.getByActiveAndEmployer(employerId));
    }

    @PostMapping("/deActive")
    public ResponseEntity<Result> deActive(@RequestBody JobPosting jobPosting) {
        return ResponseEntity.ok(jobPostingService.deActive(jobPosting));
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody JobPosting jobPosting) {
        return ResponseEntity.ok(jobPostingService.add(jobPosting));
    }
}
