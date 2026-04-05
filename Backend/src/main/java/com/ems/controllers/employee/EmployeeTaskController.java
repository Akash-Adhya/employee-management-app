package com.ems.controllers.employee;

import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.responsDto.EmployeeTaskResponseDTO;
import com.ems.service.employee.EmployeeTaskService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;



@RestController
@RequestMapping("/employee/task")
public class EmployeeTaskController {

    private final EmployeeTaskService service;

    EmployeeTaskController(EmployeeTaskService service){
        this.service = service;
    }
    
    @GetMapping("/{employeeId}/tasks")
    public List<EmployeeTaskResponseDTO> getAllTasks(@PathVariable Long employeeId) {
        List<EmployeeTaskResponseDTO> list = service.getAllTasks(employeeId);
        return list;
    }

    
    
}
