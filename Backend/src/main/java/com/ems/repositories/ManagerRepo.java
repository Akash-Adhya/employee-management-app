package com.ems.repositories;

import com.ems.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Manager,Long> {
}
