package com.ems.service;


import com.ems.requestdto.RoomServiceRequestDTO;
import com.ems.responsedto.RoomServiceResponseDTO;

public interface RoomService {
    
    RoomServiceResponseDTO createRoom(String managerId);
    RoomServiceResponseDTO updateRoom(Long roomId, RoomServiceRequestDTO room);
    void deleteRoom(RoomServiceRequestDTO room);
    RoomServiceResponseDTO fetchRoomDetails(Long RoomId);
    
}