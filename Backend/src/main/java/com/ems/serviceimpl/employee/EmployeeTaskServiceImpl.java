package com.ems.serviceimpl.employee;

import java.time.LocalDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.ems.dto.requestDto.TaskUpdateRequestDTO;
import com.ems.dto.responsDto.EmployeeTaskResponseDTO;
import com.ems.dto.responsDto.SimpleApiResponse;
import com.ems.entities.EmployeeToTask;
import com.ems.entities.Task;
import com.ems.enums.Role;
import com.ems.enums.TaskStatus;
import com.ems.exceptions.ResourceNotFound;
import com.ems.mapper.EmployeeToTaskMapper;
import com.ems.repositories.EmployeeRepo;
import com.ems.repositories.EmployeeToTaskRepo;
import com.ems.repositories.TaskRepo;
import com.ems.service.employee.EmployeeTaskService;



@Service
public class EmployeeTaskServiceImpl implements EmployeeTaskService {

    private final EmployeeRepo employeeRepo;
    private final EmployeeToTaskRepo empToTaskRepo;
    private final TaskRepo taskRepo;

    public EmployeeTaskServiceImpl(EmployeeToTaskRepo empToTaskRepo, EmployeeRepo employeeRepo, TaskRepo taskRepo) {
        this.empToTaskRepo = empToTaskRepo;
        this.employeeRepo = employeeRepo;
        this.taskRepo = taskRepo;
    }

    @Override
    public List<EmployeeTaskResponseDTO> getAllTasks(Long employeeId) {

        if (!employeeRepo.existsByIdAndUserRole(employeeId, Role.EMPLOYEE)) {
            throw new ResourceNotFound("Employee with id " + employeeId + " not found or is not an employee.");
        }

        return empToTaskRepo.findByEmployeeId(employeeId)
                .stream()
                .map(EmployeeToTaskMapper::mapToDto)
                .toList();
    }

    @Override
    public List<EmployeeTaskResponseDTO> getTasksByStatus(Long employeeId, TaskStatus status) {

        if (!employeeRepo.existsByIdAndUserRole(employeeId, Role.EMPLOYEE)) {
            throw new ResourceNotFound("Employee with id " + employeeId + " not found or is not an employee.");
        }

        if (status == null) {
            throw new IllegalArgumentException("Task status must not be null");
        }

        return empToTaskRepo.findByEmployeeIdAndTaskStatus(employeeId, status)
                .stream()
                .map(EmployeeToTaskMapper::mapToDto)
                .toList();
    }

    @Override
    public SimpleApiResponse updateTaskStatus(Long employeeTaskId, TaskStatus status) {

        EmployeeToTask et = empToTaskRepo.findById(employeeTaskId)
                .orElseThrow(() -> new ResourceNotFound(
                        "No task found for the employee with this task id : " + employeeTaskId));

        et.setTaskStatus(status);
        et.setStatusUpdationTime(LocalDateTime.now());

        empToTaskRepo.save(et);

        return new SimpleApiResponse(true, "Task status updated successfully");
    }

    @Override
    public SimpleApiResponse updateTask(Long taskId, TaskUpdateRequestDTO dto) {

        Task task = taskRepo.findById(taskId)
                .orElseThrow(() -> new ResourceNotFound("Task with id: " + taskId + " not found"));

        if (dto.getTitle() != null) {
            task.setTitle(dto.getTitle());
        }

        if (dto.getDescription() != null) {
            task.setDescription(dto.getDescription());
        }

        if (dto.getDueDate() != null) {
            task.setDueDate(dto.getDueDate());
        }

        taskRepo.save(task);

        return new SimpleApiResponse(true, "Task Updated successfully.");

    }

}
