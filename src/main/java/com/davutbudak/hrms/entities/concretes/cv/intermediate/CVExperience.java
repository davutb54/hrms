package com.davutbudak.hrms.entities.concretes.cv.intermediate;

import com.davutbudak.hrms.entities.concretes.cv.Experience;
import com.davutbudak.hrms.entities.concretes.cv.CV;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cv_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class CVExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;

    @ManyToOne
    @JoinColumn(name = "experience_id")
    private Experience experience;

    @NotEmpty
    @NotNull
    @Column(name = "start_date")
    private LocalDate startDate;

    @NotEmpty
    @NotNull
    @Column(name = "end_date")
    private LocalDate endDate;

    @NotEmpty
    @NotNull
    @Column(name = "working")
    private boolean working;
}
