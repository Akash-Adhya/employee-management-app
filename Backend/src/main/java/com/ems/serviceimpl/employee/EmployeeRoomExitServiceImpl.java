package com.ems.serviceimpl.employee;

import com.ems.dto.responsDto.ApiResponseDto;
import org.springframework.stereotype.Service;

import com.ems.dto.requestDto.RoomExitRequestDTO;
import com.ems.entities.Employee;
import com.ems.entities.Room;
import com.ems.entities.RoomExitRequest;
import com.ems.enums.Role;
import com.ems.enums.RoomExitRequestStatus;
import com.ems.exceptions.ResourceNotFound;
import com.ems.repositories.EmployeeRepo;
import com.ems.repositories.RoomExitRequestRepo;
import com.ems.service.employee.EmployeeRoomExitService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeRoomExitServiceImpl implements EmployeeRoomExitService {

    private final EmployeeRepo employeeRepo;
    private final RoomExitRequestRepo roomExitRequestRepo;

    @Override
    public ApiResponseDto<String> createExitRequest(Long employeeId, RoomExitRequestDTO dto) {

        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFound(
                        "Employee not found with id: " + employeeId));

        if (employee.getUser().getRole() != Role.EMPLOYEE) {
            throw new IllegalStateException("User is not an employee");
        }

        Room room = employee.getRoom();

        if (room == null) {
            throw new ResourceNotFound("Employee is not assigned to any room");
        }

        boolean alreadyRequested = roomExitRequestRepo
                .existsByEmployeeAndStatus(employee, RoomExitRequestStatus.REQUESTED);

        if (alreadyRequested) {
            throw new IllegalStateException("Exit request already pending");
        }

        RoomExitRequest request = new RoomExitRequest();
        request.setReason(dto.getReason());
        request.setEmployee(employee);
        request.setRoom(room);
        request.setManager(room.getManager());

        roomExitRequestRepo.save(request);

        return new ApiResponseDto<String>("Room exit request is submitted successfully!", 200, "");
    }

}
