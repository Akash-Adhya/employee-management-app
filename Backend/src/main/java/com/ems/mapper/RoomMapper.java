package com.ems.mapper;


import com.ems.dto.responsDto.EmployeeBasicResponseDTO;
import com.ems.dto.responsDto.RoomResponseDTO;
import com.ems.entities.Room;



public class RoomMapper {

    public static RoomResponseDTO mapToRoomResponseDTO(Room room) {
        RoomResponseDTO dto = new RoomResponseDTO();

        dto.setRoomName(room.getRoomName());
        dto.setDescription(room.getDescription());
        dto.setRoomCode(room.getRoomCode());
        dto.setIsLocked(room.isLocked());

        if (room.getManager() != null) {
            RoomResponseDTO.ManagerBasicResponseDto managerDto = new RoomResponseDTO.ManagerBasicResponseDto();

            managerDto.setName(room.getManager().getUser().getName());
            managerDto.setEmail(room.getManager().getUser().getEmail());
            managerDto.setEmployeeId(room.getManager().getUser().getEmployeeId());
            managerDto.setImageUrl(room.getManager().getUser().getImageUrl());
            managerDto.setDepartment(room.getManager().getDepartment());
            managerDto.setDesignation(room.getManager().getManagerDesignation());

            dto.setManager(managerDto);
        }

        dto.setEmployees(
                room.getEmployees()
                        .stream()
                        .map(emp -> new EmployeeBasicResponseDTO(
                                emp.getUser().getName(),
                                emp.getUser().getEmail(),
                                emp.getUser().getEmployeeId(),
                                emp.getUser().getImageUrl(),
                                emp.getUser().getAccountStatus().name(),
                                emp.getJoiningDate()))
                        .toList());

        return dto;
    }
}
