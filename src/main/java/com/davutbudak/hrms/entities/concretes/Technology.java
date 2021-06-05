package com.davutbudak.hrms.entities.concretes;

import com.davutbudak.hrms.entities.concretes.cv.intermediate.CvTechnology;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "technologies")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

}
