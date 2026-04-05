package com.ems.controllers.employee;

import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.responsDto.EmployeeTaskResponseDTO;
import com.ems.enums.TaskStatus;
import com.ems.service.employee.EmployeeTaskService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/employee/task")
public class EmployeeTaskController {

    private final EmployeeTaskService service;

    EmployeeTaskController(EmployeeTaskService service) {
        this.service = service;
    }

    @GetMapping("/{employeeId}/tasks")
    public ResponseEntity<List<EmployeeTaskResponseDTO>> getAllTasks(@PathVariable Long employeeId) {
        List<EmployeeTaskResponseDTO> list = service.getAllTasks(employeeId);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{employeeId}/tasks/{status}")
    public ResponseEntity<List<EmployeeTaskResponseDTO>> getTasksByStatus(
            @Valid @PathVariable Long employeeId,
            @Valid @PathVariable TaskStatus status) {
                
        List<EmployeeTaskResponseDTO> list = service.getTasksByStatus(employeeId, status);
        return ResponseEntity.ok().body(list);
    }

}
