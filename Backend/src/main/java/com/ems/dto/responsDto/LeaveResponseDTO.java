package com.ems.dto.responsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeaveResponseDTO {
    private String title;

    private String description;

    private String category;

    private LocalDate startDate;

    private LocalDate endDate;

    private String leaveStatus;

    private LocalDateTime appliedAt;

    private LocalDateTime statusUpdatedAt;
}
