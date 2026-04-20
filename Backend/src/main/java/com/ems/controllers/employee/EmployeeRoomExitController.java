package com.ems.controllers.employee;

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

        String message = employeeRoomExitService.createExitRequest(roomExitRequestDTO);
        return new ApiResponseDto<>(message, 200, "");
    }

}
