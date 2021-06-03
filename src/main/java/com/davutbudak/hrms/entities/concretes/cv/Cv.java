package com.davutbudak.hrms.entities.concretes.cv;

import com.davutbudak.hrms.entities.concretes.cv.intermediate.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonIgnore
    @OneToMany(mappedBy = "cv")
    private List<CvCandidate> cvCandidates;

    @JsonIgnore
    @OneToMany(mappedBy = "cv")
    private List<CvImage> cvImages;

    @JsonIgnore
    @OneToMany(mappedBy = "cv")
    private List<CvEducation> cvEducations;

    @JsonIgnore
    @OneToMany(mappedBy = "cv")
    private List<CvKnownLanguage> cvKnownLanguages;

    @JsonIgnore
    @OneToMany(mappedBy = "cv")
    private List<CvExperience> cvExperiences;

    @JsonIgnore
    @OneToMany
    private List<CvTechnology> cvTechnologies;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "github")
    private String github;

    @Column(name = "linkedin")
    private String linkedin;
}
