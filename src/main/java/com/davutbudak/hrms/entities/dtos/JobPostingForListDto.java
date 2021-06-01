package com.davutbudak.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingForListDto {
    private int id;
    private String companyName;
    private String jobPositionName;
    private int numberOfOpenPositions;
    private Date releaseDate;
    private Date deadline;
}
