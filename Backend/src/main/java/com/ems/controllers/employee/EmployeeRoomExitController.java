package com.ems.controllers.employee;

import com.ems.dto.requestDto.RoomExitRequestDTO;
import com.ems.dto.responsDto.ApiResponseDto;
import com.ems.service.employee.EmployeeRoomExitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee/room-exit")
public class EmployeeRoomExitController {

    private EmployeeRoomExitService employeeRoomExitService;

    @PostMapping
    public ApiResponseDto<String> createExitStatus(
            @RequestBody RoomExitRequestDTO roomExitRequestDTO
            ) {

        
        return employeeRoomExitService.createExitRequest(roomExitRequestDTO);
    }

}
