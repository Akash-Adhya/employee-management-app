package com.ems.controllers.employee;

import com.ems.dto.responsDto.RoomResponseDTO;
import com.ems.service.employee.EmployeeRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee/room")
public class EmployeeRoomController {
    EmployeeRoomService employeeRoomService;

    @GetMapping
    public ResponseEntity<RoomResponseDTO> getEmployeeRoom(){
        return ResponseEntity.ok(employeeRoomService.getMyRoomDetails());
    }
}
