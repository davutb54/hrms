package com.davutbudak.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "job_postings")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "employer_id")
    private int employerId;

    @Column(name = "job_position_id")
    private int jobPositionId;

    @Column(name = "city_id")
    private int cityId;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "number_of_open_positions")
    private int numberOfOpenPositions;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "active")
    private boolean active;
}
