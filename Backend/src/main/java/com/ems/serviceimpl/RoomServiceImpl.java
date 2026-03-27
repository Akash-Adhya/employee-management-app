package com.ems.serviceImpl;


import org.springframework.stereotype.Service;

import com.ems.entities.Room;
import com.ems.repositories.RoomRepository;
import com.ems.repositories.UserRepository;
import com.ems.service.RoomService;


@Service
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    

    public RoomServiceImpl(RoomRepository roomRepository, UserRepository userRepository) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Room createRoom(String managerId) {
        return null;
    }

    @Override
    public Room updateRoom(Long roomId, Room room) {
        return null;
    }

    @Override
    public void deleteRoom(Room room) {

    }

    @Override
    public Room fetchRoomDetails(Long RoomId) {
        return null;
    }

   
    
}
