package com.davutbudak.hrms.entities.dtos.cv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CvForAddDto {
    private int id;
    private int candidateId;
    private int imageId;
    private int[] educationIds;
    private int[] knownLanguageIds;
    private int[] experienceIds;
    private int[] technologyIds;
    private String coverLetter;
    private String github;
    private String linkedin;
}
