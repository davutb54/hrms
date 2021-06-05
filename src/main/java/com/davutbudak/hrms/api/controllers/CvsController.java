package com.davutbudak.hrms.api.controllers;

import com.davutbudak.hrms.business.abstracts.CvService;
import com.davutbudak.hrms.entities.dtos.cv.CvForAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {
    private final CvService cvService;

    @Autowired
    public CvsController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/getByCandidate")
    public ResponseEntity<?> getByCandidate(@RequestParam int candidateId){
        return ResponseEntity.ok(cvService.getByCandidate(candidateId));
    }

    @GetMapping("/getAllSortedByExperience")
    public ResponseEntity<?> getAllSortedByExperience(){
        return ResponseEntity.ok(cvService.getAllSortedByExperience());
    }

    @GetMapping("/getAllSortedByGraduate")
    public  ResponseEntity<?> getAllSortedByGraduate(){
        return ResponseEntity.ok(cvService.getAllSortedByGraduate());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CvForAddDto cv){
        return ResponseEntity.ok(cvService.add(cv));
    }
}
