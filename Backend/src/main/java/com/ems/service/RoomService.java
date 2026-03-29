package com.ems.service;

import com.ems.requestdto.room.RoomCreationRequestDTO;
import com.ems.requestdto.room.RoomUpdationRequestDTO;
import com.ems.responsedto.room.EmployeeResponseRoomDTO;
import com.ems.responsedto.room.RoomResponseDTO;
import com.ems.responsedto.task.ManagerTaskResponseDTO;

import java.util.List;

public interface RoomService {

    // MANAGER METHODS
    RoomResponseDTO createRoom(
            String managerEmpId,
            RoomCreationRequestDTO dto
    );


    RoomResponseDTO updateRoom(
            Long roomId,
            String managerEmpId,
            RoomUpdationRequestDTO dto
    );


    void deleteRoom(
            Long roomId,
            String managerEmpId
    );


    RoomResponseDTO getRoomById(
            Long roomId,
            String managerEmpId
    );


    List<RoomResponseDTO> getAllRoomCreatedByManager(String managerEmpId);


    List<EmployeeResponseRoomDTO> getAllEmployeeOfTheRoom(Long roomId, String managerEmpId);


    List<ManagerTaskResponseDTO> getAllTaskCreatedOnTheRoom(
            Long roomId,
            String managerEmpId
    );


    // EMPLOYEE METHODS

    RoomResponseDTO getRoomByCode(String roomCode);
}