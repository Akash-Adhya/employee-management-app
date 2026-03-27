package com.ems.serviceImpl;


import org.springframework.stereotype.Service;

import com.ems.entities.Room;
import com.ems.service.RoomService;


@Service
public class RoomServiceImpl implements RoomService{

    private final Room room;

    public RoomServiceImpl(Room room){
        this.room = room;
    }

    @Override
    public Room createRoom(String managerId) {
        return null;
    }

    @Override
    public Room updateRoom(Room room) {
        return null;
    }

    @Override
    public Room deleteRoom(Room room) {
        return null;
    }

    @Override
    public Room fetchRoomDetails(String RoomId) {
        return null;
    }
    
}
