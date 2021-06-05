package com.davutbudak.hrms.api.controllers;

import com.davutbudak.hrms.business.abstracts.JobPostingService;
import com.davutbudak.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobPostings")
public class JobPostingsController {
    private final JobPostingService jobPostingService;

    @Autowired
    public JobPostingsController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @GetMapping("/getActives")
    public ResponseEntity<?> getActiveJobPostings() {
        return ResponseEntity.ok(jobPostingService.getByActive());
    }

    @GetMapping("/getActivesSortedByReleaseDate")
    public ResponseEntity<?> getActivesSortedByReleaseDate() {
        return ResponseEntity.ok(jobPostingService.getByActiveSortedByReleaseDate());
    }

    @GetMapping("/getActivesByEmployer")
    public ResponseEntity<?> getActivesByEmployer(@RequestParam int employerId) {
        return ResponseEntity.ok(jobPostingService.getByActiveAndEmployer(employerId));
    }

    @PostMapping("/deActive")
    public ResponseEntity<?> deActive(@RequestBody JobPosting jobPosting) {
        return ResponseEntity.ok(jobPostingService.deActive(jobPosting));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobPosting jobPosting) {
        return ResponseEntity.ok(jobPostingService.add(jobPosting));
    }
}
