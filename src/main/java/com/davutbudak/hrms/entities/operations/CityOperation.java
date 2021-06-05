package com.davutbudak.hrms.entities.operations;

import com.davutbudak.hrms.dataAccess.abstracts.CityDao;
import com.davutbudak.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityOperation {
    private static CityDao cityDao;

    @Autowired
    public CityOperation(CityDao cityDao) {
        CityOperation.cityDao = cityDao;
    }

    public static List<JobPosting> geJobPostings(int cityId) {
        return cityDao.getJobPostings(cityId);
    }
}
