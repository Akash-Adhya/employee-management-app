package com.ems.mapper;

import com.ems.dto.responsDto.LeaveResponseDTO;
import com.ems.entities.LeaveRequest;

public class LeaveMapper {

    public static LeaveResponseDTO leaveRequestToLeaveResponseDTO(LeaveRequest leave) {
        return new LeaveResponseDTO(
                leave.getTitle(),
                leave.getDescription(),
                leave.getCategory().name(),
                leave.getStartDate(),
                leave.getEndDate(),
                leave.getLeaveStatus().name(),
                leave.getAppliedAt(),
                leave.getStatusUpdatedAt());
    }

}
