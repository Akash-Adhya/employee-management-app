package com.ems.controllers.employee;

import com.ems.dto.responsDto.ApiResponseDto;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.responsDto.EmployeeTaskResponseDTO;
import com.ems.enums.TaskStatus;
import com.ems.service.employee.EmployeeTaskService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


import java.util.List;

@RestController
@RequestMapping("/employee/task")
public class EmployeeTaskController {

    private final EmployeeTaskService service;

    EmployeeTaskController(EmployeeTaskService service) {
        this.service = service;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<EmployeeTaskResponseDTO>> getAllTasks() {
        List<EmployeeTaskResponseDTO> list = service.getAllTasks();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/tasks/{status}")
    public ResponseEntity<List<EmployeeTaskResponseDTO>> getTasksByStatus(
            @Valid @PathVariable TaskStatus status) {

        List<EmployeeTaskResponseDTO> list = service.getTasksByStatus(status);
        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/task/status/{employeeTaskId}")
    public ApiResponseDto<String> updateTaskStatus(@PathVariable Long employeeTaskId,
                                                           @RequestParam TaskStatus status) {
        String message = service.updateTaskStatus(employeeTaskId, status);
        return new ApiResponseDto<>(message, 200, "");
    }


}
