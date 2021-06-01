package com.davutbudak.hrms.entities.concretes.cv;

import com.davutbudak.hrms.entities.concretes.cv.intermediate.CVUniversity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "universities")
@AllArgsConstructor
@NoArgsConstructor
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvUniversities"})
    @OneToMany(mappedBy = "university")
    private List<CVUniversity> cvUniversities;
}
