package com.davutbudak.hrms.dataAccess.abstracts;

import com.davutbudak.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    List<JobAdvertisement> findAllByActive(boolean isActive);
    List<JobAdvertisement> findAllByActiveOrderByReleaseDate(boolean isActive);
    List<JobAdvertisement> findAllByActiveAndEmployer_Id(boolean isActive,int employerId);

}
