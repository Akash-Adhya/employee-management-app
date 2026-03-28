package com.ems.service;

import com.ems.enums.TaskStatus;
import com.ems.requestdto.task.CreateTaskRequestDTO;
import com.ems.requestdto.task.UpdateTaskRequestDTO;
import com.ems.responsedto.task.EmployeeTaskResponseDTO;
import com.ems.responsedto.task.EmployeeTaskSummaryDTO;
import com.ems.responsedto.task.ManagerTaskResponseDTO;

import java.util.List;

public interface TaskService {

    // MANAGER METHODS

    ManagerTaskResponseDTO createTask(
            String managerEmpId,
            CreateTaskRequestDTO dto
    );


    ManagerTaskResponseDTO updateTask(
            String managerEmpId,
            Long taskId,
            UpdateTaskRequestDTO dto
    );


    List<EmployeeTaskSummaryDTO> getAllEmployeesAssignedOnTheTask(
            String managerEmpId,
            Long taskId
    );


    List<ManagerTaskResponseDTO> getAllTaskCreatedByTheManager(
            String managerEmpId
    );


    void deleteTask(
            Long taskId,
            String managerEmpId
    );



    // EMPLOYEE METHODS

    List<EmployeeTaskResponseDTO> getAllTaskAssignedToTheEmployee(
            String employeeId
    );


    EmployeeTaskResponseDTO getTaskForEmployee(
            String employeeId,
            Long taskId
    );


    EmployeeTaskResponseDTO updateTaskStatusByEmpId(
            String employeeId,
            Long taskId,
            TaskStatus status
    );
}