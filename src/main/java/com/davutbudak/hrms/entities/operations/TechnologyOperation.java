package com.davutbudak.hrms.entities.operations;

import com.davutbudak.hrms.dataAccess.abstracts.TechnologyDao;
import com.davutbudak.hrms.entities.concretes.cv.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TechnologyOperation {
    private static TechnologyDao technologyDao;

    @Autowired
    public TechnologyOperation(TechnologyDao technologyDao) {
        TechnologyOperation.technologyDao = technologyDao;
    }

    private static List<Cv> getCvs(int technologyId) {
        return technologyDao.getCvs(technologyId);
    }
}
