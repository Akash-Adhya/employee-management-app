package com.ems.service;

import com.ems.entities.Room;

public interface RoomService {
    
    public Room createRoom(String managerId);
    public Room updateRoom(Room room);
    public Room deleteRoom(Room room);
    public Room fetchRoomDetails(String RoomId);

}