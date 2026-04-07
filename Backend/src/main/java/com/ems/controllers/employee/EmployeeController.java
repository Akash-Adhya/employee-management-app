package com.ems.controllers.employee;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.responsDto.NotificationResponseDTO;
import com.ems.service.employee.EmployeeNotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeNotificationService notificationService;

    @GetMapping("/get/notification/{employeeId}")
    public List<NotificationResponseDTO> getNotifications(
            @PathVariable Long employeeId) {

        return notificationService.getNotifications(employeeId);
    }
}
