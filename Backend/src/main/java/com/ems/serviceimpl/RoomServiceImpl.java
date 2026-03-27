package com.ems.serviceimpl;


import org.springframework.stereotype.Service;

import com.ems.entities.Room;
import com.ems.repositories.RoomRepository;
import com.ems.repositories.UserRepository;
import com.ems.requestdto.RoomServiceRequestDTO;
import com.ems.responsedto.RoomServiceResponseDTO;
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
    public RoomServiceResponseDTO createRoom(String managerId) {
        return null;
    }

    @Override
    public RoomServiceResponseDTO updateRoom(Long roomId, RoomServiceRequestDTO room) {
        return null;
    }

    @Override
    public void deleteRoom(RoomServiceRequestDTO room) {

    }

    @Override
    public RoomServiceResponseDTO fetchRoomDetails(Long RoomId) {
        return null;
    }

   
    
}
