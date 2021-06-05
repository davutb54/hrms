package com.davutbudak.hrms.entities.dtos.cv;

import com.davutbudak.hrms.entities.concretes.Institution;
import com.davutbudak.hrms.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExperienceForListDto {
    private int id;
    private JobPosition jobPosition;
    private Institution institution;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean working;
}
