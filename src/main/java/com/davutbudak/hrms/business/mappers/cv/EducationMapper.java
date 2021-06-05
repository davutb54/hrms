package com.davutbudak.hrms.business.mappers.cv;

import com.davutbudak.hrms.entities.concretes.cv.Education;
import com.davutbudak.hrms.entities.dtos.cv.EducationForListDto;
import com.davutbudak.hrms.entities.operations.cv.EducationOperation;

public class EducationMapper {
    public static EducationForListDto educationToList(Education education) {
        return EducationForListDto.builder()
                .id(education.getId())
                .university(EducationOperation.getUniversity(education.getId()))
                .startDate(education.getStartDate())
                .dateOfGraduation(education.getDateOfGraduation())
                .graduated(education.isGraduated())
                .build();
    }
}
