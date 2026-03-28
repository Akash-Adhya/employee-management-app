package com.ems.serviceimpl;


import com.ems.requestdto.room.RoomCreationRequestDTO;
import com.ems.requestdto.room.RoomUpdationRequestDTO;
import com.ems.responsedto.room.EmployeeResponseRoomDTO;
import com.ems.responsedto.room.RoomResponseDTO;
import com.ems.responsedto.task.ManagerTaskResponseDTO;
import org.springframework.stereotype.Service;

import com.ems.service.RoomService;

import java.util.List;


@Service
public class RoomServiceImpl implements RoomService{
    @Override
    public RoomResponseDTO createRoom(String managerEmpId, RoomCreationRequestDTO dto) {
        return null;
    }

    @Override
    public RoomResponseDTO updateRoom(String managerEmpId, RoomUpdationRequestDTO dto) {
        return null;
    }

    @Override
    public void deleteRoom(Long roomId, String managerEmpId) {

    }

    @Override
    public RoomResponseDTO getRoomById(Long roomId, String managerEmpId) {
        return null;
    }

    @Override
    public List<RoomResponseDTO> getAllRoomCreatedByManager(String managerEmpId) {
        return List.of();
    }

    @Override
    public List<EmployeeResponseRoomDTO> getAllEmployeeOfTheRoom(Long roomId) {
        return List.of();
    }

    @Override
    public List<ManagerTaskResponseDTO> getAllTaskCreatedOnTheRoom(Long roomId) {
        return List.of();
    }

    @Override
    public RoomResponseDTO getRoomByCode(String roomCode) {
        return null;
    }
}
