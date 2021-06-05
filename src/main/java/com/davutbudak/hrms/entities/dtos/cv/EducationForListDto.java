package com.davutbudak.hrms.entities.dtos.cv;

import com.davutbudak.hrms.entities.concretes.University;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducationForListDto {
    private int id;
    private University university;
    private LocalDate startDate;
    private LocalDate dateOfGraduation;
    private boolean graduated;
}
