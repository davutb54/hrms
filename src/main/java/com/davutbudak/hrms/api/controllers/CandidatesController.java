package com.davutbudak.hrms.api.controllers;

import com.davutbudak.hrms.business.abstracts.CandidateService;
import com.davutbudak.hrms.entities.concretes.users.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(candidateService.getAll());
    }
     @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Candidate candidate){
        return ResponseEntity.ok(candidateService.add(candidate));
    }
}
