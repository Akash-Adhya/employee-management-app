package com.ems.service.employee;

import com.ems.dto.responsDto.EmployeeTaskResponseDTO;
import com.ems.enums.TaskStatus;

import java.util.List;

public interface EmployeeTaskService {

    List<EmployeeTaskResponseDTO> getAllTasks();
    List<EmployeeTaskResponseDTO> getTasksByStatus(TaskStatus status);
    String updateTaskStatus(Long employeeTaskId, TaskStatus status);
}
