package com.ems.serviceimpl.employee;

import com.ems.dto.responsDto.ApiResponseDto;
import com.ems.dto.responsDto.EmployeeTaskResponseDTO;
import com.ems.entities.Employee;
import com.ems.entities.EmployeeToTask;
import com.ems.entities.User;
import com.ems.enums.TaskStatus;
import com.ems.exceptions.AuthorizationException;
import com.ems.exceptions.ResourceNotFound;
import com.ems.mapper.EmployeeToTaskMapper;
import com.ems.repositories.EmployeeToTaskRepo;
import com.ems.service.employee.EmployeeTaskService;
import com.ems.utils.SecurityUtil;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;


@Service
public class EmployeeTaskServiceImpl implements EmployeeTaskService {

    private final EmployeeToTaskRepo empToTaskRepo;
    private final SecurityUtil securityUtil;

    public EmployeeTaskServiceImpl(EmployeeToTaskRepo empToTaskRepo, SecurityUtil securityUtil) {
        this.empToTaskRepo = empToTaskRepo;
        this.securityUtil = securityUtil;
    }

    private Employee validateAndGetEmployee(){
        User user = securityUtil.getCurrentUser();
        securityUtil.validateEmployee(user);
        return securityUtil.getEmployee(user);
    }

    @Override
    public List<EmployeeTaskResponseDTO> getAllTasks() {

        Employee employee = validateAndGetEmployee();


        return empToTaskRepo.findByEmployeeId(employee.getId())
                .stream()
                .map(EmployeeToTaskMapper::mapToDto)
                .toList();
    }

    @Override
    public List<EmployeeTaskResponseDTO> getTasksByStatus(TaskStatus status) {

        Employee employee = validateAndGetEmployee();


        return empToTaskRepo
                .findByEmployeeIdAndTaskStatus(employee.getId(), status)
                .stream()
                .map(EmployeeToTaskMapper::mapToDto)
                .toList();
    }

    @Override
    public String updateTaskStatus(Long employeeTaskId, TaskStatus status) {

        Employee employee = validateAndGetEmployee();

        EmployeeToTask et = empToTaskRepo.findById(employeeTaskId)
                .orElseThrow(() -> new ResourceNotFound("No task found with id: " + employeeTaskId));

        if(!et.getEmployee().getId().equals(employee.getId())){
            throw new AuthorizationException("You are not allowed to update this task");
        }

        et.setTaskStatus(status);
        et.setStatusUpdationTime(LocalDateTime.now());

        empToTaskRepo.save(et);

        return "Task status updated successfully";
    }

}
