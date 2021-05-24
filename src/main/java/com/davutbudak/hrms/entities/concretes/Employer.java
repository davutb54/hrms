package com.davutbudak.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User{

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "website")
    private String website;

    @Column(name = "telephone")
    private String telephone;
}
