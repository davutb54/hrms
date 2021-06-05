package com.davutbudak.hrms.entities.dtos.cv;

import com.davutbudak.hrms.entities.concretes.Image;
import com.davutbudak.hrms.entities.concretes.Technology;
import com.davutbudak.hrms.entities.concretes.users.Candidate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CvForListDto {
    private int id;
    private Candidate candidate;
    private Image image;
    private List<EducationForListDto> educations;
    private List<KnownLanguageForListDto> languages;
    private List<ExperienceForListDto> experiences;
    private List<Technology> technologies;
    private String coverLetter;
    private String github;
    private String linkedin;
}
