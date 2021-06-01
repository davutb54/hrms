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
public class JobPostingsController {
    private JobPostingService jobPostingService;

    @Autowired
    public JobPostingsController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @GetMapping("/getActives")
    public ResponseEntity<?> getActiveJobPostings(){
        return ResponseEntity.ok(this.jobPostingService.getByActive());
    }

    @GetMapping("/getActivesSortedByReleaseDate")
    public ResponseEntity<?> getActivesSortedByReleaseDate(){
        return ResponseEntity.ok(this.jobPostingService.getByActiveSortedByReleaseDate());
    }

    @GetMapping("/getActivesByEmployer")
    public ResponseEntity<?> getActivesByEmployer(@RequestParam int employerId){
        return ResponseEntity.ok(this.jobPostingService.getByActiveAndEmployer(employerId));
    }

    @PostMapping("/deActive")
    public ResponseEntity<?> deActive(@RequestBody JobPosting jobPosting){
        return ResponseEntity.ok(this.jobPostingService.deActive(jobPosting));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobPosting jobPosting){
        return ResponseEntity.ok(this.jobPostingService.add(jobPosting));
    }
}
