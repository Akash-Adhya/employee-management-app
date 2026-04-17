package com.ems.service.employee;

import java.util.List;

import com.ems.dto.requestDto.LeaveRequestDTO;
import com.ems.dto.responsDto.LeaveResponseDTO;

public interface EmployeeLeaveService {

    LeaveResponseDTO createLeaveRequest(LeaveRequestDTO requestDTO);
    List<LeaveResponseDTO> getLeaveRequest();
    List<LeaveResponseDTO> getLeaveRequestByStatus(String status);


    
}
