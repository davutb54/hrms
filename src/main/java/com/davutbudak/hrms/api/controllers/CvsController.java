package com.davutbudak.hrms.api.controllers;

import com.davutbudak.hrms.business.abstracts.CvService;
import com.davutbudak.hrms.core.utilities.results.DataResult;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.entities.dtos.cv.CvForAddDto;
import com.davutbudak.hrms.entities.dtos.cv.CvForListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvs")
@CrossOrigin
public class CvsController {
    private final CvService cvService;

    @Autowired
    public CvsController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/getByCandidate")
    public ResponseEntity<DataResult<CvForListDto>> getByCandidate(@RequestParam int candidateId) {
        return ResponseEntity.ok(cvService.getByCandidate(candidateId));
    }

    @GetMapping("/getAllSortedByExperience")
    public ResponseEntity<DataResult<List<CvForListDto>>> getAllSortedByExperience() {
        return ResponseEntity.ok(cvService.getAllSortedByExperience());
    }

    @GetMapping("/getAllSortedByGraduate")
    public ResponseEntity<DataResult<List<CvForListDto>>> getAllSortedByGraduate() {
        return ResponseEntity.ok(cvService.getAllSortedByGraduate());
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody CvForAddDto cv) {
        return ResponseEntity.ok(cvService.add(cv));
    }
}
