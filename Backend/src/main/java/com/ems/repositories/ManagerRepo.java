package com.ems.repositories;

import com.ems.entities.Manager;
import com.ems.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepo extends JpaRepository<Manager,Long> {
    Optional<Manager> findByUser(User user);
}
