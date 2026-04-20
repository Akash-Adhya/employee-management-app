package com.ems.service.employee;

import com.ems.dto.requestDto.LeaveRequestDTO;
import com.ems.dto.responsDto.LeaveResponseDTO;

import java.util.List;

public interface EmployeeLeaveService {

    LeaveResponseDTO createLeaveRequest(LeaveRequestDTO requestDTO);

    List<LeaveResponseDTO> getLeaveRequest();

    List<LeaveResponseDTO> getLeaveRequestByStatus(String status);

}
