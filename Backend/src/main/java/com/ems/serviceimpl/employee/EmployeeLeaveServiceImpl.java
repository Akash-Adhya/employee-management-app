package com.ems.serviceimpl.employee;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ems.entities.User;
import com.ems.utils.SecurityUtil;
import org.springframework.stereotype.Service;

import com.ems.dto.requestDto.LeaveRequestDTO;
import com.ems.dto.responsDto.LeaveResponseDTO;
import com.ems.entities.Employee;
import com.ems.entities.LeaveRequest;
import com.ems.enums.LeaveStatus;
import com.ems.exceptions.ResourceNotFound;
import com.ems.mapper.LeaveMapper;
import com.ems.repositories.EmployeeRepo;
import com.ems.repositories.LeaveRequestRepo;
import com.ems.service.employee.EmployeeLeaveService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {

    private final LeaveRequestRepo leaveRequestRepo;
    private final EmployeeRepo employeeRepo;
    private final SecurityUtil securityUtil;

    private Employee validateAndGetEmployee(){
        User user = securityUtil.getCurrentUser();
        securityUtil.validateEmployee(user);
        return securityUtil.getEmployee(user);
    }

    @Override
    public LeaveResponseDTO createLeaveRequest(LeaveRequestDTO requestDTO) {

        Employee employee = validateAndGetEmployee();

        if (requestDTO.getEndDate().isBefore(requestDTO.getStartDate())) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }

        LeaveRequest leave = new LeaveRequest();

        leave.setTitle(requestDTO.getTitle());
        leave.setDescription(requestDTO.getDescription());

        leave.setCategory(requestDTO.getCategory());

        leave.setStartDate(requestDTO.getStartDate());
        leave.setEndDate(requestDTO.getEndDate());

        leave.setLeaveStatus(LeaveStatus.REQUESTED);

        leave.setAppliedAt(LocalDateTime.now());
        leave.setEmployee(employee);

        LeaveRequest saved = leaveRequestRepo.save(leave);

        return LeaveMapper.leaveRequestToLeaveResponseDTO(saved);

    }

    @Override
    public List<LeaveResponseDTO> getLeaveRequest() {

        Employee employee = validateAndGetEmployee();

        return leaveRequestRepo.findByEmployeeId(employee.getId())
                .stream()
                .map(LeaveMapper::leaveRequestToLeaveResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LeaveResponseDTO> getLeaveRequestByStatus(String status) {

        Employee employee = validateAndGetEmployee();

        LeaveStatus leaveStatus = LeaveStatus.valueOf(status.toUpperCase());

        return leaveRequestRepo.findByEmployeeIdAndLeaveStatus(employee.getId(), leaveStatus)
                .stream()
                .map(LeaveMapper::leaveRequestToLeaveResponseDTO)
                .collect(Collectors.toList());
    }
}
