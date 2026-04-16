package com.ems.service.employee;

import com.ems.dto.requestDto.RoomExitRequestDTO;
import com.ems.dto.responsDto.ApiResponseDto;

public interface EmployeeRoomExitService {
    public ApiResponseDto<String> createExitRequest(Long employeeId, RoomExitRequestDTO dto);
}
