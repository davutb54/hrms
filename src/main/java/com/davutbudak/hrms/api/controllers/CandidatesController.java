package com.davutbudak.hrms.api.controllers;

import com.davutbudak.hrms.business.abstracts.CandidateService;
import com.davutbudak.hrms.core.utilities.results.DataResult;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.entities.concretes.users.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {
    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<Candidate>>> getAll() {
        return ResponseEntity.ok(candidateService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody Candidate candidate) {
        return ResponseEntity.ok(candidateService.add(candidate));
    }
}
