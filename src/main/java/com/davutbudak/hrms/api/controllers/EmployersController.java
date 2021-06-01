package com.davutbudak.hrms.api.controllers;

import com.davutbudak.hrms.business.abstracts.EmployerService;
import com.davutbudak.hrms.core.utilities.results.DataResult;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.entities.concretes.users.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.employerService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Employer employer){
        return ResponseEntity.ok(this.employerService.add(employer));
    }
}
