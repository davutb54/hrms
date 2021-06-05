package com.davutbudak.hrms.entities.concretes.cv.intermediate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cv_technologies")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CvTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cv_id")
    private int cvId;

    @Column(name = "technology_id")
    private int technologyId;
}
