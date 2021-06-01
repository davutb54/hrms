package com.davutbudak.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class Employer extends User{

    @NotEmpty
    @NotNull
    @Column(name = "company_name")
    private String companyName;

    @NotEmpty
    @NotNull
    @Column(name = "website")
    private String website;

    @NotEmpty
    @NotNull
    @Column(name = "telephone")
    private String telephone;

    @OneToMany(mappedBy = "employer")
    private List<JobPosting> jobPostings;

}
