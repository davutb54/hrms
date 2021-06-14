package com.davutbudak.hrms.entities.dtos;

import com.davutbudak.hrms.entities.enums.WorkPlace;
import com.davutbudak.hrms.entities.enums.WorkTime;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class JobPostingForListDto {
    private int id;
    private String companyName;
    private String jobPositionName;
    private int numberOfOpenPositions;
    private LocalDate releaseDate;
    private LocalDate deadline;
    private String workTime;
    private String workPlace;

    public JobPostingForListDto(int id, String companyName, String jobPositionName, int numberOfOpenPositions, LocalDate releaseDate, LocalDate deadline, WorkTime workTime, WorkPlace workPlace) {
        this.id = id;
        this.companyName = companyName;
        this.jobPositionName = jobPositionName;
        this.numberOfOpenPositions = numberOfOpenPositions;
        this.releaseDate = releaseDate;
        this.deadline = deadline;
        this.workTime = workTime.getName();
        this.workPlace = workPlace.getName();
    }
}
