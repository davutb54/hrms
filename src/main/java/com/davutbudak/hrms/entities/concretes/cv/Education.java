package com.davutbudak.hrms.entities.concretes.cv;

import com.davutbudak.hrms.entities.concretes.University;
import com.davutbudak.hrms.entities.concretes.cv.intermediate.CvEducation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "educations")
@AllArgsConstructor
@NoArgsConstructor
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "date_of_graduation")
    private LocalDate dateOfGraduation;

    @Column(name = "graduated")
    private boolean graduated;

    @JsonIgnore
    @OneToMany(mappedBy = "education")
    private List<CvEducation> cvEducations;
}
