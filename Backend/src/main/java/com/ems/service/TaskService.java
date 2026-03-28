package com.ems.service;

import com.ems.requestdto.task.CreateTaskRequestDTO;
import com.ems.requestdto.task.UpdateTaskRequestDTO;
import com.ems.responsedto.task.EmployeeTaskResponseDTO;
import com.ems.responsedto.task.EmployeeTaskSummaryDTO;
import com.ems.responsedto.task.ManagerTaskResponseDTO;

import java.util.List;

public interface TaskService {
    //manager
    ManagerTaskResponseDTO createTask(String managerEmpId, CreateTaskRequestDTO dto);
    ManagerTaskResponseDTO updateTask(String managerEmpId,Long taskId, UpdateTaskRequestDTO dto);
    List<EmployeeTaskSummaryDTO> getAllEmployeesAssignedOnTheTask(String managerEmpId,Long taskId);
    List<ManagerTaskResponseDTO> getAllTaskCreatedByTheManager(String managerEmpId);
    void deleteTask(Long taskId,String managerEmpId);

    //employee
    List<EmployeeTaskResponseDTO> getAllTaskAssignedToTheEmployee(String employeeId);
    EmployeeTaskResponseDTO getTaskByEmpId(String employeeId,Long taskId);
    EmployeeTaskResponseDTO updateTaskStatusByEmpId(String employeeId,String status);
}
