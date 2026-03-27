package com.ems.service;

import com.ems.entities.Room;

public interface RoomService {
    
    Room createRoom(String managerId);
    Room updateRoom(Long roomId, Room room);
    void deleteRoom(Room room);
    Room fetchRoomDetails(Long RoomId);
    
}