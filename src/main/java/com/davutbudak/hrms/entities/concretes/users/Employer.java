package com.davutbudak.hrms.entities.concretes.users;

import com.davutbudak.hrms.entities.concretes.JobPosting;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "website")
    private String website;

    @Column(name = "telephone")
    private String telephone;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobPosting> jobPostings;

}
