package com.davutbudak.hrms.entities.concretes.cv.intermediate;

import com.davutbudak.hrms.entities.concretes.cv.Image;
import com.davutbudak.hrms.entities.concretes.cv.CV;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cv_images")
@AllArgsConstructor
@NoArgsConstructor
public class CVImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;
}
