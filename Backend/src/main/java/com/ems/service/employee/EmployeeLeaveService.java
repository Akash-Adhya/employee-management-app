package com.ems.service.employee;

import java.util.List;

import com.ems.dto.requestDto.LeaveRequestDTO;
import com.ems.dto.responsDto.LeaveResponseDTO;

public interface EmployeeLeaveService {

    LeaveResponseDTO createLeaveRequest(Long employeeId, LeaveRequestDTO requestDTO);
    List<LeaveResponseDTO> getLeaveRequest(Long employeeId);
    List<LeaveResponseDTO> getLeaveRequestByStatus(Long employeeId, String status);

}
