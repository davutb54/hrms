package com.davutbudak.hrms.dataAccess.abstracts;

import com.davutbudak.hrms.entities.concretes.cv.CV;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVDao extends JpaRepository<CV,Integer> {
}
