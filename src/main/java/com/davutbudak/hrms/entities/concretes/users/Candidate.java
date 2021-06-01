package com.davutbudak.hrms.entities.concretes.users;

import com.davutbudak.hrms.entities.concretes.cv.CV;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Candidate extends User {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "identity_Number")
    private String identityNumber;

    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvs"})
    @OneToMany(mappedBy = "candidate")
    private List<CV> cvs;
}
