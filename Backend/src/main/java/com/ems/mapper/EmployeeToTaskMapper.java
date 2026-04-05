package com.ems.mapper;

import com.ems.dto.responsDto.EmployeeTaskResponseDTO;
import com.ems.entities.EmployeeToTask;

public class EmployeeToTaskMapper {

    public static EmployeeTaskResponseDTO mapToDto(EmployeeToTask et) {
        EmployeeTaskResponseDTO dto = new EmployeeTaskResponseDTO();

        dto.setTaskId(et.getTask().getId());
        dto.setTitle(et.getTask().getTitle());
        dto.setDescription(et.getTask().getDescription());

        dto.setTaskStatus(et.getTaskStatus().name());
        dto.setStatusUpdateTime(et.getStatusUpdationTime());

        return dto;
    }
}
