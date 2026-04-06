package com.ems.serviceimpl.employee;

import org.springframework.stereotype.Service;

import com.ems.dto.responsDto.RoomResponseDTO;
import com.ems.entities.Employee;
import com.ems.entities.Room;
import com.ems.enums.Role;
import com.ems.exceptions.ResourceNotFound;
import com.ems.mapper.RoomMapper;
import com.ems.repositories.EmployeeRepo;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class EmployeeRoomServiceImpl {
    private final EmployeeRepo employeeRepo;

    public RoomResponseDTO getRoomDetailsByEmployeeId(Long employeeId){
        Employee employee = employeeRepo.findById(employeeId)
            .orElseThrow(() -> new ResourceNotFound("Employee not found with id: " + employeeId));

        
        if(employee.getUser().getRole() != Role.EMPLOYEE){
            throw new ResourceNotFound("User is not an employee with id: " + employeeId);
        }

        Room room = employee.getRoom();

        if(room == null){
            throw new ResourceNotFound("Employee is not assigned to any room");
        }

        return RoomMapper.toRoomResponseDTO(room);
    }
}
