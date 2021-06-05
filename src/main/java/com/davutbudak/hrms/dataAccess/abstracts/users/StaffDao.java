package com.davutbudak.hrms.dataAccess.abstracts.users;

import com.davutbudak.hrms.entities.concretes.users.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffDao extends JpaRepository<Staff, Integer> {
}
