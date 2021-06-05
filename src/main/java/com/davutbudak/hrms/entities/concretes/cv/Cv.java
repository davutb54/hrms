package com.davutbudak.hrms.entities.concretes.cv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "cvs")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "candidate_id")
    private int candidateId;

    @Column(name = "image_id")
    private int imageId;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "github")
    private String github;

    @Column(name = "linkedin")
    private String linkedin;
}
