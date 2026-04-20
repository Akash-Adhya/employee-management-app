package com.ems.controllers.employee;

import com.ems.dto.responsDto.ApiResponseDto;
import com.ems.dto.responsDto.RoomResponseDTO;
import com.ems.service.employee.EmployeeRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee/room")
@RequiredArgsConstructor
public class EmployeeRoomController {

    private final EmployeeRoomService employeeRoomService;

    @GetMapping("/room-details")
    public ApiResponseDto<RoomResponseDTO> getRoomDetails() {
        return new ApiResponseDto<>("Room details of employee", 200, employeeRoomService.getRoomDetailsOfEmployee());
    }
    
}
