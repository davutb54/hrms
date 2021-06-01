package com.davutbudak.hrms.entities.concretes.cv;

import com.davutbudak.hrms.entities.concretes.JobPosition;
import com.davutbudak.hrms.entities.concretes.cv.intermediate.CVExperience;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "experiences")
@AllArgsConstructor
@NoArgsConstructor
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @Column(name = "workplace")
    private String workplace;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvExperiences"})
    @OneToMany(mappedBy = "experience")
    private List<CVExperience> cvExperiences;
}
