package com.davutbudak.hrms.entities.concretes.cv.intermediate;

import com.davutbudak.hrms.entities.concretes.cv.Language;
import com.davutbudak.hrms.entities.concretes.cv.CV;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cv_languages")
@AllArgsConstructor
@NoArgsConstructor
public class CVLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "level")
    private int level;
}
