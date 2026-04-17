package com.ems.controllers.employee;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.requestDto.LeaveRequestDTO;
import com.ems.dto.responsDto.LeaveResponseDTO;
import com.ems.service.employee.EmployeeLeaveService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee/leave-request")
@RequiredArgsConstructor
public class EmployeeLeaveController {

    private final EmployeeLeaveService leaveService;

    @PostMapping("/create/leave-request/{employeeId}")
    public LeaveResponseDTO createLeave(
            @PathVariable Long employeeId,
            @Valid @RequestBody LeaveRequestDTO requestDTO) {

        return leaveService.createLeaveRequest(requestDTO);
    }

    @GetMapping("/get/leave-request/{employeeId}")
    public List<LeaveResponseDTO> getLeaves(@PathVariable Long employeeId) {
        return leaveService.getLeaveRequest();
    }

    @GetMapping("/leave-request/{status}/{employeeId}")
    public List<LeaveResponseDTO> getLeavesByStatus(
            @PathVariable String status,
            @PathVariable Long employeeId) {

        return leaveService.getLeaveRequestByStatus(status);
    }

}
