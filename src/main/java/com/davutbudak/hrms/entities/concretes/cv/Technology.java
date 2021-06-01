package com.davutbudak.hrms.entities.concretes.cv;

import com.davutbudak.hrms.entities.concretes.cv.intermediate.CVTechnology;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "technologies")
@AllArgsConstructor
@NoArgsConstructor
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvTechnologies"})
    @OneToMany(mappedBy = "technology")
    private List<CVTechnology> cvTechnologies;
}
