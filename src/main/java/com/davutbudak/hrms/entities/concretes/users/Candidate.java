package com.davutbudak.hrms.entities.concretes.users;

import com.davutbudak.hrms.entities.concretes.cv.intermediate.CvCandidate;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CvCandidate> cvCandidates;

}
