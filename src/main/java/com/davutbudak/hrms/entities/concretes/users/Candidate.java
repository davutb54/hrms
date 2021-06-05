package com.davutbudak.hrms.entities.concretes.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
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
}
