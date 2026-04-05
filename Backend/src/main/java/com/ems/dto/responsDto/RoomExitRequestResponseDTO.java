package com.ems.dto.responsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomExitRequestResponseDTO {
    private EmployeeBasicResponseDTO employee;

    private String reason;

    private LocalDateTime requestTime;

    private String requestStatus;

    private String roomName;
}
