package com.ems.service.employee;

import com.ems.dto.requestDto.RoomExitRequestDTO;
import com.ems.dto.responsDto.SimpleApiResponse;

public interface EmployeeRoomExitService {
    public SimpleApiResponse createExitRequest(Long employeeId, RoomExitRequestDTO dto);
}
