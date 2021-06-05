package com.davutbudak.hrms.dataAccess.abstracts;

import com.davutbudak.hrms.entities.concretes.Technology;
import com.davutbudak.hrms.entities.concretes.cv.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {
    @Query("select cv from Cv  as cv join CvTechnology as cvt on cv.id = cvt.cvId join Technology as t on cvt.technologyId = t.id where t.id =:technologyId")
    List<Cv> getCvs(@Param("technologyId") int technologyId);
}
