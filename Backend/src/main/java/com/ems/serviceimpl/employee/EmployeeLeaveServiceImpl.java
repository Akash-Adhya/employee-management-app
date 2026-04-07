package com.ems.serviceimpl.employee;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public LeaveResponseDTO createLeaveRequest(Long employeeId, LeaveRequestDTO requestDTO) {

        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFound("Employee not found with id: " + employeeId));

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
    public List<LeaveResponseDTO> getLeaveRequest(Long employeeId) {

        employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFound("Employee not found with id: " + employeeId));

        return leaveRequestRepo.findByEmployeeId(employeeId)
                .stream()
                .map(LeaveMapper::leaveRequestToLeaveResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LeaveResponseDTO> getLeaveRequestByStatus(Long employeeId, String status) {

        employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFound("Employee not found with id: " + employeeId));

        LeaveStatus leaveStatus = LeaveStatus.valueOf(status.toUpperCase());

        return leaveRequestRepo.findByEmployeeIdAndLeaveStatus(employeeId, leaveStatus)
                .stream()
                .map(LeaveMapper::leaveRequestToLeaveResponseDTO)
                .collect(Collectors.toList());
    }
}
