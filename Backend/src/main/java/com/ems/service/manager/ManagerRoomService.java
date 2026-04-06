package com.ems.service.manager;

import com.ems.dto.requestDto.RoomRequestDTO;
import com.ems.dto.requestDto.RoomUpdateRequestDTO;
import com.ems.dto.responsDto.EmployeeBasicResponseDTO;
import com.ems.dto.responsDto.RoomResponseDTO;

import java.util.List;

public interface ManagerRoomService {
    RoomResponseDTO createRoom(String employeeId,RoomRequestDTO dto);
    RoomResponseDTO updateRoom(Long roomId, RoomUpdateRequestDTO dto);
    String lockRoom(Long roomId);
    String unlockRoom(Long roomId);
    List<EmployeeBasicResponseDTO> getAllEmployeeInARoom(Long roomId);
    List<RoomResponseDTO> getAllRoomOfAManager(String employeeId);
}
