package com.davutbudak.hrms.entities.concretes.cv;

import com.davutbudak.hrms.entities.concretes.cv.intermediate.CVImage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvImages"})
    @OneToMany(mappedBy = "image")
    private List<CVImage> cvImages;
}
