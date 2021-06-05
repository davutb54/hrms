package com.davutbudak.hrms.dataAccess.abstracts.users;

import com.davutbudak.hrms.entities.concretes.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
