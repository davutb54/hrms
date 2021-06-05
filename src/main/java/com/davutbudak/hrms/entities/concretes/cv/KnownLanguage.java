package com.davutbudak.hrms.entities.concretes.cv;

import com.davutbudak.hrms.entities.concretes.cv.intermediate.CvKnownLanguage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "known_languages")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KnownLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language_id")
    private int languageId;

    @Column(name = "level")
    private int level;
}
