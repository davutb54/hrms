
package com.davutbudak.hrms.api.controllers;

import com.davutbudak.hrms.business.abstracts.JobPositionService;
import com.davutbudak.hrms.core.utilities.results.DataResult;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPositions")
@CrossOrigin
public class JobPositionsController {
    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<JobPosition>>> getAll() {
        return ResponseEntity.ok(jobPositionService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody JobPosition jobPosition) {
        return ResponseEntity.ok(jobPositionService.add(jobPosition));
    }

}