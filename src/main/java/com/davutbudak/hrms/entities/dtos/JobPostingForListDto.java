package com.davutbudak.hrms.entities.dtos;

import com.davutbudak.hrms.entities.enums.WorkPlace;
import com.davutbudak.hrms.entities.enums.WorkTime;
import com.davutbudak.hrms.entities.operations.JobPostingOperation;
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
    private String city;
    private String description;
    private int minSalary;
    private int maxSalary;

    public JobPostingForListDto(int id, int numberOfOpenPositions, LocalDate releaseDate, LocalDate deadline, WorkTime workTime, WorkPlace workPlace, String description, int minSalary, int maxSalary) {
        this.id = id;
        this.companyName = JobPostingOperation.getEmployer(this.id).getCompanyName();
        this.jobPositionName = JobPostingOperation.getJobPosition(this.id).getName();
        this.numberOfOpenPositions = numberOfOpenPositions;
        this.releaseDate = releaseDate;
        this.deadline = deadline;
        this.workTime = workTime.getName();
        this.workPlace = workPlace.getName();
        this.city = JobPostingOperation.getCity(this.id).getName();
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }
}
