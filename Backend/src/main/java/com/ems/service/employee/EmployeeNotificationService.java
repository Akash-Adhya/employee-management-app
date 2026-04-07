package com.ems.service.employee;

import java.util.List;

import com.ems.dto.responsDto.NotificationResponseDTO;

public interface EmployeeNotificationService {
    List<NotificationResponseDTO> getNotifications(Long employeeId);
}
