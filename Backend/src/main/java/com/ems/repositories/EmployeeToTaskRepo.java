package com.ems.repositories;

import com.ems.entities.EmployeeToTask;
import com.ems.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeToTaskRepo extends JpaRepository<EmployeeToTask, Long> {

    List<EmployeeToTask> findByEmployeeId(Long employeeId);

    List<EmployeeToTask> findByEmployeeIdAndTaskStatus(Long employeeId, TaskStatus status);
}