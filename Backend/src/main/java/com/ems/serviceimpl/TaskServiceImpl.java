package com.ems.serviceimpl;

import com.ems.enums.TaskStatus;
import com.ems.requestdto.task.CreateTaskRequestDTO;
import com.ems.requestdto.task.UpdateTaskRequestDTO;
import com.ems.responsedto.task.EmployeeTaskResponseDTO;
import com.ems.responsedto.task.EmployeeTaskSummaryDTO;
import com.ems.responsedto.task.ManagerTaskResponseDTO;
import com.ems.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    @Override
    public ManagerTaskResponseDTO createTask(String managerEmpId, CreateTaskRequestDTO dto) {
        return null;
    }

    @Override
    public ManagerTaskResponseDTO updateTask(String managerEmpId, Long taskId, UpdateTaskRequestDTO dto) {
        return null;
    }

    @Override
    public List<EmployeeTaskSummaryDTO> getAllEmployeesAssignedOnTheTask(String managerEmpId, Long taskId) {
        return List.of();
    }

    @Override
    public List<ManagerTaskResponseDTO> getAllTaskCreatedByTheManager(String managerEmpId) {
        return List.of();
    }

    @Override
    public void deleteTask(Long taskId, String managerEmpId) {

    }

    @Override
    public List<EmployeeTaskResponseDTO> getAllTaskAssignedToTheEmployee(String employeeId) {
        return List.of();
    }

    @Override
    public EmployeeTaskResponseDTO getTaskForEmployee(String employeeId, Long taskId) {
        return null;
    }

    @Override
    public EmployeeTaskResponseDTO updateTaskStatusByEmpId(String employeeId, Long taskId, TaskStatus status) {
        return null;
    }
}
