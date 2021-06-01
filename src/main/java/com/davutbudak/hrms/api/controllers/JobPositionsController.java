
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
public class JobPositionsController {
    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(jobPositionService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobPosition jobPosition){
        return ResponseEntity.ok(this.jobPositionService.add(jobPosition));
    }

}