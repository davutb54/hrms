package com.davutbudak.hrms.entities.concretes;

import com.davutbudak.hrms.entities.enums.WorkPlace;
import com.davutbudak.hrms.entities.enums.WorkTime;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @Column(name = "work_time")
    @Enumerated(EnumType.STRING)
    private WorkTime workTime;

    @Column(name = "work_place")
    @Enumerated(EnumType.STRING)
    private WorkPlace workPlace;

    @Column(name = "number_of_open_positions")
    private int numberOfOpenPositions;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "release_date")
    private LocalDate releaseDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "active")
    private boolean active;
}
