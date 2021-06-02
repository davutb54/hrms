package com.davutbudak.hrms.api.controllers;

import com.davutbudak.hrms.business.abstracts.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cvs")
public class CVsController {
    private CVService cvService;

    @Autowired
    public CVsController(CVService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/getByCandidate")
    public ResponseEntity<?> getByCandidate(@RequestParam int candidateId){
        return ResponseEntity.ok(this.cvService.getByCandidate(candidateId));
    }
}
