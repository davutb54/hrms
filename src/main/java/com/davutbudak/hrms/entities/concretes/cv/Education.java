package com.davutbudak.hrms.entities.concretes.cv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "educations")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "university_id")
    private int universityId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "date_of_graduation")
    private LocalDate dateOfGraduation;

    @Column(name = "graduated")
    private boolean graduated;
}
