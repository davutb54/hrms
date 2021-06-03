package com.davutbudak.hrms.entities.concretes.cv;

import com.davutbudak.hrms.entities.concretes.Language;
import com.davutbudak.hrms.entities.concretes.cv.intermediate.CvKnownLanguage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "known_languages")
@AllArgsConstructor
@NoArgsConstructor
public class KnownLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "level")
    private int level;

    @JsonIgnore
    @OneToMany(mappedBy = "knownLanguage")
    private List<CvKnownLanguage> cvKnownLanguages;
}
