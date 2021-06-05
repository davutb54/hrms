package com.davutbudak.hrms.dataAccess.abstracts;

import com.davutbudak.hrms.entities.concretes.City;
import com.davutbudak.hrms.entities.concretes.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityDao extends JpaRepository<City, Integer> {
    @Query("select jp from JobPosting as jp join City as c on jp.cityId = c.id where c.id = :cityId")
    List<JobPosting> getJobPostings(@Param("cityId") int cityId);
}
