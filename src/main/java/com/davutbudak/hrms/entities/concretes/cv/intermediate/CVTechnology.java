package com.davutbudak.hrms.entities.concretes.cv.intermediate;

import com.davutbudak.hrms.entities.concretes.cv.CV;
import com.davutbudak.hrms.entities.concretes.cv.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cv_technologies")
@AllArgsConstructor
@NoArgsConstructor
public class CVTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;

    @ManyToOne
    @JoinColumn(name = "technology_id")
    private Technology technology;
}
