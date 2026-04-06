package com.ems.dto.responsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponseDTO {
    private Long roomId;

    private String roomName;

    private String description;

    private String roomCode;

    private Boolean isLocked;

    private ManagerBasicResponseDto manager;

    private List<EmployeeBasicResponseDTO> employees;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ManagerBasicResponseDto {

        private String name;

        private String email;

        private String employeeId;

        private String imageUrl;

        private String department;

        private String designation;
    }
}
