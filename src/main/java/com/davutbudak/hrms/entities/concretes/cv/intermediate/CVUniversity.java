package com.davutbudak.hrms.entities.concretes.cv.intermediate;

import com.davutbudak.hrms.entities.concretes.cv.University;
import com.davutbudak.hrms.entities.concretes.cv.CV;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "cv_universities")
@AllArgsConstructor
@NoArgsConstructor
public class CVUniversity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "date_of_graduation")
    private LocalDate dateOfGraduation;

    @Column(name = "graduated")
    private boolean graduated;
}
