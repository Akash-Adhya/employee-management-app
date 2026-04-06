package com.ems.mapper;


import com.ems.dto.responsDto.EmployeeBasicResponseDTO;
import com.ems.dto.responsDto.RoomResponseDTO;
import com.ems.entities.Manager;
import com.ems.entities.Room;
import com.ems.entities.User;


import java.util.List;

public class RoomMapper {
    public static RoomResponseDTO toRoomResponseDTO(Room room){
        RoomResponseDTO dto = new RoomResponseDTO();
        dto.setRoomId(room.getId());

        dto.setRoomName(room.getRoomName());
        dto.setDescription(room.getDescription());
        dto.setRoomCode(room.getRoomCode());
        dto.setIsLocked(room.isLocked());


        Manager manager = room.getManager();
        RoomResponseDTO.ManagerBasicResponseDto obj = new RoomResponseDTO.ManagerBasicResponseDto();

        User user = manager.getUser();
        obj.setName(user.getName());
        obj.setEmail(user.getEmail());
        obj.setEmployeeId(user.getEmployeeId());
        obj.setImageUrl(user.getImageUrl());
        obj.setDesignation(manager.getManagerDesignation());
        obj.setDepartment(manager.getDepartment());

        dto.setManager(obj);

        List<EmployeeBasicResponseDTO> employeeBasicResponseDTOS =
                room.getEmployees()
                        .stream()
                        .map(EmployeeMapper::toEmployeeBasicResponseDTO)
                        .toList();
        dto.setEmployees(employeeBasicResponseDTOS);
        return dto;
    }
}
