package com.ems.serviceimpl.employee;

import com.ems.entities.User;
import com.ems.service.employee.EmployeeRoomService;
import com.ems.utils.SecurityUtil;
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
public class EmployeeRoomServiceImpl implements EmployeeRoomService {

    private final SecurityUtil securityUtil;

    private Employee validateAndGetEmployee(){
        User user = securityUtil.getCurrentUser();
        securityUtil.validateEmployee(user);
        return securityUtil.getEmployee(user);
    }


    @Override
    public RoomResponseDTO getMyRoomDetails() {
        Employee employee = validateAndGetEmployee();

        Room room = employee.getRoom();

        if (room == null){
            throw new ResourceNotFound("Employee is not assigned to any room");
        }

        return RoomMapper.toRoomResponseDTO(room);
    }

}
