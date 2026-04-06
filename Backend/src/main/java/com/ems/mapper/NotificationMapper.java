package com.ems.mapper;

import com.ems.dto.responsDto.NotificationResponseDTO;
import com.ems.entities.Notification;

public class NotificationMapper {
    public static NotificationResponseDTO toNotificationResponseDto(Notification notification){
        NotificationResponseDTO dto = new NotificationResponseDTO();
        dto.setMessage(notification.getMessage());
        dto.setIsRead(notification.isRead());
        dto.setCreatedAt(notification.getCreatedAt());
        return dto;
    }
}
