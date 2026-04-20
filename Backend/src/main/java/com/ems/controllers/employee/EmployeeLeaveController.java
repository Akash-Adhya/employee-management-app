package com.ems.controllers.employee;

import com.ems.dto.requestDto.LeaveRequestDTO;
import com.ems.dto.responsDto.ApiResponseDto;
import com.ems.dto.responsDto.LeaveResponseDTO;
import com.ems.service.employee.EmployeeLeaveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/leave-request")
@RequiredArgsConstructor
public class EmployeeLeaveController {

    private final EmployeeLeaveService leaveService;

    @PostMapping("/create/leave-request/")
    public ApiResponseDto<LeaveResponseDTO> createLeave(
            @Valid @RequestBody LeaveRequestDTO requestDTO) {

        return new ApiResponseDto<>("Leave Request Created", 200, leaveService.createLeaveRequest(requestDTO));
    }

    @GetMapping("/get/leave-request/")
    public ApiResponseDto<List<LeaveResponseDTO>> getLeaves() {
        return new ApiResponseDto<>("All leave requests", 200, leaveService.getLeaveRequest());
    }

    @GetMapping("/leave-request/{status}/{employeeId}")
    public ApiResponseDto<List<LeaveResponseDTO>> getLeavesByStatus(
            @PathVariable String status) {

        return new ApiResponseDto<>("Leave request by status", 200, leaveService.getLeaveRequestByStatus(status));
    }

}
