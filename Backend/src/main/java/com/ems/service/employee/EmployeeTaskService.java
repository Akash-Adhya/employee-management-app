package com.ems.service.employee;

import com.ems.dto.requestDto.TaskUpdateRequestDTO;
import com.ems.dto.responsDto.ApiResponseDto;
import com.ems.dto.responsDto.EmployeeTaskResponseDTO;
import com.ems.enums.TaskStatus;

import java.util.List;

public interface EmployeeTaskService {

    List<EmployeeTaskResponseDTO> getAllTasks(Long employeeId);
    List<EmployeeTaskResponseDTO> getTasksByStatus(Long employeeId, TaskStatus status);
    ApiResponseDto<String> updateTask(Long taskId, TaskUpdateRequestDTO dto);
    ApiResponseDto<String> updateTaskStatus(Long employeeId, TaskStatus status);
}
