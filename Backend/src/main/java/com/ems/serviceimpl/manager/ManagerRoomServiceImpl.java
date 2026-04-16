package com.ems.serviceimpl.manager;

import com.ems.dto.requestDto.RoomRequestDTO;
import com.ems.dto.requestDto.RoomUpdateRequestDTO;
import com.ems.dto.responsDto.EmployeeBasicResponseDTO;
import com.ems.dto.responsDto.RoomResponseDTO;
import com.ems.entities.Employee;
import com.ems.entities.Manager;
import com.ems.entities.Room;
import com.ems.entities.User;
import com.ems.enums.Role;
import com.ems.exceptions.ResourceNotFound;
import com.ems.mapper.EmployeeMapper;
import com.ems.mapper.RoomMapper;
import com.ems.repositories.ManagerRepo;
import com.ems.repositories.RoomRepo;
import com.ems.repositories.UserRepo;
import com.ems.service.manager.ManagerRoomService;
import com.ems.utils.SecurityUtil;
import com.ems.utils.Utility;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ManagerRoomServiceImpl implements ManagerRoomService {

    private final RoomRepo roomRepo;
    private final SecurityUtil securityUtil;

    @Override
    public RoomResponseDTO createRoom(RoomRequestDTO dto) {

        User user = securityUtil.getCurrentUser();
        securityUtil.validateManager(user);
        Manager manager = securityUtil.getManager(user);

        Room room = new Room();

        room.setRoomName(dto.getRoomName());
        room.setDescription(dto.getDescription());
        room.setRoomCode(Utility.generateRoomCode());
        room.setManager(manager);

        Room savedRoom = roomRepo.save(room);
        return RoomMapper.toRoomResponseDTO(savedRoom);
    }


    @Override
    public RoomResponseDTO updateRoom(Long roomId, RoomUpdateRequestDTO dto) {

        Room room = getRoomById(roomId);
        if (dto.getRoomName() != null) {
            room.setRoomName(dto.getRoomName());
        }
        if (dto.getDescription() != null) {
            room.setDescription(dto.getDescription());
        }
        Room updatedRoom = roomRepo.save(room);
        return RoomMapper.toRoomResponseDTO(updatedRoom);
    }


    @Override
    public String lockRoom(Long roomId) {

        Room room = getRoomById(roomId);
        room.setLocked(true);
        return "Room locked successfully : " + room.getRoomName();
    }


    @Override
    public String unlockRoom(Long roomId) {
        Room room = getRoomById(roomId);
        room.setLocked(false);
        return "Room unlocked successfully : " + room.getRoomName();
    }

    @Override
    public List<EmployeeBasicResponseDTO> getAllEmployeeInARoom(Long roomId) {
        Room room = getRoomById(roomId);
        List<Employee> employeeList = room.getEmployees();
        List<EmployeeBasicResponseDTO> employeeBasicResponseDTOS =
                employeeList
                        .stream()
                        .map(EmployeeMapper::toEmployeeBasicResponseDTO)
                        .toList();
        return employeeBasicResponseDTOS;
    }

    @Override
    public List<RoomResponseDTO> getAllRoomOfAManager() {
        User user = securityUtil.getCurrentUser();
        securityUtil.validateManager(user);
        Manager manager = securityUtil.getManager(user);

        List<Room> roomList = roomRepo.findByManager(manager);
        List<RoomResponseDTO> roomResponseDTOS =
                roomList.stream()
                        .map(RoomMapper::toRoomResponseDTO)
                        .toList();
        return roomResponseDTOS;
    }

    private Room getRoomById(Long roomId) {
        return roomRepo.findById(roomId)
                .orElseThrow(() ->
                        new ResourceNotFound(
                                "Room not found with ID: " + roomId
                        )
                );
    }
}