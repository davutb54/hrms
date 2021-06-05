package com.davutbudak.hrms.api.controllers;

import com.davutbudak.hrms.business.abstracts.EmployerService;
import com.davutbudak.hrms.entities.concretes.users.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
    private final EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(employerService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Employer employer) {
        return ResponseEntity.ok(employerService.add(employer));
    }
}
