package com.davutbudak.hrms.business.mappers.cv;

import com.davutbudak.hrms.entities.concretes.cv.Experience;
import com.davutbudak.hrms.entities.dtos.cv.ExperienceForListDto;
import com.davutbudak.hrms.entities.operations.cv.ExperienceOperation;

public class ExperienceMapper {
    public static ExperienceForListDto experienceToList(Experience experience){
        return ExperienceForListDto.builder()
                .id(experience.getId())
                .jobPosition(ExperienceOperation.getJobPosition(experience.getId()))
                .institution(ExperienceOperation.getInstitution(experience.getId()))
                .startDate(experience.getStartDate())
                .endDate(experience.getEndDate())
                .working(experience.isWorking())
                .build();
    }
}
