package com.davutbudak.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Entity
@Table(name = "job_postings")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty
    @NotNull
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @NotEmpty
    @NotNull
    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @NotEmpty
    @NotNull
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @NotEmpty
    @NotNull
    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @NotEmpty
    @NotNull
    @Column(name = "number_of_open_positions")
    private int numberOfOpenPositions;

    @NotEmpty
    @NotNull
    @Column(name = "release_date")
    private Date releaseDate;

    @NotEmpty
    @NotNull
    @Column(name = "deadline")
    private Date deadline;

    @NotEmpty
    @NotNull
    @Column(name = "is_active")
    private boolean active;
}
