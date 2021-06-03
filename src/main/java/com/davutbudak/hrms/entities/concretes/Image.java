package com.davutbudak.hrms.entities.concretes;

import com.davutbudak.hrms.entities.concretes.cv.intermediate.CvImage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "images")
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "url")
    private String url;

    @JsonIgnore
    @OneToMany(mappedBy = "image")
    private List<CvImage> cvImages;
}
