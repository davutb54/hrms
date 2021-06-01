package com.davutbudak.hrms.entities.concretes.cv;

import com.davutbudak.hrms.entities.concretes.cv.intermediate.*;
import com.davutbudak.hrms.entities.concretes.users.Candidate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cvs")
@AllArgsConstructor
@NoArgsConstructor
public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvImages"})
    @OneToMany(mappedBy = "cv")
    private List<CVImage> cvImages;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvUniversities"})
    @OneToMany(mappedBy = "cv")
    private List<CVUniversity> cvUniversities;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvLanguages"})
    @OneToMany(mappedBy = "cv")
    private List<CVLanguage> cvLanguages;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvExperiences"})
    @OneToMany(mappedBy = "cv")
    private List<CVExperience> cvExperiences;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvTechnologies"})
    @OneToMany(mappedBy = "cv")
    private List<CVTechnology> cvTechnologies;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "github")
    private String github;

    @Column(name = "linkedin")
    private String linkedin;
}
