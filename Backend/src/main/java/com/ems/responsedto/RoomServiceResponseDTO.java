package com.ems.responsedto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomServiceResponseDTO {

    private String roomCode;
    private String roomName;
    private String description;
    private Long managerId;
    private LocalDateTime createdAt;

    // have to send the list of employees
    private List<EmployeeResponseDTO> employeeDTOs;

}
