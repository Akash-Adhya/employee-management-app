package com.ems.repositories;

import com.ems.entities.EmployeeToTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeToTaskRepo extends JpaRepository<EmployeeToTask,Long> {
}
