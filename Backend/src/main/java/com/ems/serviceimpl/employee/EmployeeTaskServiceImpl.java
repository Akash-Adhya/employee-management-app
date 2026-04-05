package com.ems.serviceimpl.employee;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.dto.responsDto.EmployeeTaskResponseDTO;
import com.ems.enums.TaskStatus;
import com.ems.mapper.EmployeeToTaskMapper;
import com.ems.repositories.EmployeeToTaskRepo;
import com.ems.service.employee.EmployeeTaskService;

@Service
public class EmployeeTaskServiceImpl implements EmployeeTaskService {

    private final EmployeeToTaskRepo repo;

    public EmployeeTaskServiceImpl(EmployeeToTaskRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<EmployeeTaskResponseDTO> getAllTasks(Long employeeId) {

        return repo.findByEmployeeId(employeeId)
                .stream()
                .map(EmployeeToTaskMapper::mapToDto)
                .toList();
    }

    @Override
    public List<EmployeeTaskResponseDTO> getTasksByStatus(Long employeeId, TaskStatus status) {

        return repo.findByEmployeeIdAndTaskStatus(employeeId, status)
                .stream()
                .map(EmployeeToTaskMapper::mapToDto)
                .toList();
    }

}
