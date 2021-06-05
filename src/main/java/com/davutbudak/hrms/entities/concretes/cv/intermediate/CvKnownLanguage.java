package com.davutbudak.hrms.entities.concretes.cv.intermediate;

import com.davutbudak.hrms.entities.concretes.cv.Cv;
import com.davutbudak.hrms.entities.concretes.cv.KnownLanguage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cv_known_languages")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CvKnownLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cv_id")
    private int cvId;

    @Column(name = "known_language_id")
    private int knownLanguageId;

}
