package com.ems.responsedto.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponseDTO {

    private Long roomId;

    private String roomName;
    private String description;

    private String roomCode;


    private String managerName;
    private String managerEmail;

    private int totalEmployees;
    private int totalTasks;

    private LocalDateTime createdAt;
}
