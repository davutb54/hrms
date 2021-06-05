package com.davutbudak.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobPostingForListDto {
    private int id;
    private String companyName;
    private String jobPositionName;
    private int numberOfOpenPositions;
    private LocalDate releaseDate;
    private LocalDate deadline;
}
